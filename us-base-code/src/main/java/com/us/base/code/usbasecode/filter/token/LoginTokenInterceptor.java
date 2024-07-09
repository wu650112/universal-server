package com.us.base.code.usbasecode.filter.token;

import com.github.pagehelper.StringUtil;
import com.us.base.code.usbasecode.annotation.NotNeedToken;
import com.us.base.code.usbasecode.base.enums.BaseBizsExceptionEnum;
import com.us.base.code.usbasecode.base.exception.UsBaseException;
import com.us.base.code.usbasecode.util.BaseUserInfo;
import com.us.base.code.usbasecode.util.UsJwtUtil;
import com.us.base.code.usbasecode.util.UsRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token 配置认证服务器
 */
@Component
@Slf4j
public class LoginTokenInterceptor extends HandlerInterceptorAdapter {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String TOKEN_HEADER = "Authorization";
    private static final Long EXPIRATION_TIME = 24 * 60 * 60L;

    @Autowired
    private UsJwtUtil jwtUtil;

    @Autowired
    private UsRedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        NotNeedToken needTokenAnnotation = handlerMethod.getMethodAnnotation(NotNeedToken.class);
        boolean needToken = needTokenAnnotation != null;
        log.info("请求链接：" + request.getRequestURI());

        String authorizationHeader = request.getHeader(TOKEN_HEADER);
        if (needToken) {
            return super.preHandle(request, response, handler);
        }
        String token = "";
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            token = authorizationHeader.replace(TOKEN_PREFIX, "");
        }
        if (StringUtil.isEmpty(token)) {
            throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_NOT_FIND);
        }

        if (!jwtUtil.validateToken(token)) {
            throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_INVALID);
        }

        BaseUserInfo baseUserInfo = jwtUtil.getUserBaseInfo(token);
        if (baseUserInfo == null) {
            throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_INVALID);
        }

        UserContext.setUser(baseUserInfo);


        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.clear();
        super.afterCompletion(request, response, handler, ex);
    }
}
