package com.us.base.code.usbasecode.filter.token;

import com.github.pagehelper.StringUtil;
import com.us.base.code.usbasecode.annotation.NeedToken;
import com.us.base.code.usbasecode.base.constant.UsRedisKeyConstant;
import com.us.base.code.usbasecode.base.dao.BaseUserInfo;
import com.us.base.code.usbasecode.base.enums.BaseBizsExceptionEnum;
import com.us.base.code.usbasecode.base.exception.UsBaseException;
import com.us.base.code.usbasecode.util.UsByteUtil;
import com.us.base.code.usbasecode.util.UsCodeUtil;
import com.us.base.code.usbasecode.util.UsJwtUtil;
import com.us.base.code.usbasecode.util.UsRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * token 配置认证服务器
 *
 * @author wufan
 * @date 2023/7/21
 */
@Component
@Slf4j
public class LoginTokenInterceptor extends HandlerInterceptorAdapter {

    /**
     * 定义 Bearer token 的前缀
     */
    private static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 请求头中的标头名称
     */
    private static final String TOKEN_HEADER = "Authorization";

    /**
     * 幂等校验的过期时间是1天
     */
    private final static Long EXPIRATION_TIME = 24 * 60 * 60L;

    @Autowired
    private UsJwtUtil jwtUtil;

    @Autowired
    private UsRedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断访问的方法上是否有 @NeedToken 注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        UsHttpServletRequestWrapper requestWrapper = new UsHttpServletRequestWrapper(request);
        NeedToken needTokenAnnotation = handlerMethod.getMethodAnnotation(NeedToken.class);
        boolean needToken = needTokenAnnotation != null;
        log.info("请求链接：" + request.getRequestURI());
        // 从请求头获取 Authorization 标头
        String authorizationHeader = request.getHeader(TOKEN_HEADER);
        // 若 Authorization 标头存在且以 Bearer 开头
        if (needToken) {
            String token = "";
            if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
                // 提取出 token 部分
                token = authorizationHeader.replace(TOKEN_PREFIX, "");
            }
            if (StringUtil.isEmpty(token)) {
                throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_NOT_FIND);
            }

            // 验证 token
            if (!jwtUtil.validateToken(token)) {
                throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_INVALID);
            }

            // 是否开启了幂等校验 todo 还是有点问题的 暂时不写这个先
            if (needTokenAnnotation.idempotence()) {
                BaseUserInfo baseUserInfo = jwtUtil.getUserBaseInfo(token);
                if (baseUserInfo == null) {
                    throw new UsBaseException(BaseBizsExceptionEnum.IDEMPOTENCE_INVALID);
                }
                String body = UsByteUtil.readRawRequestBody(request);
                String checker = baseUserInfo.getLoginName() + request.getRequestURI() + body;

                checker = UsCodeUtil.md5Hex(checker.getBytes(StandardCharsets.UTF_8));
                log.warn("幂等校验码：" + checker);
                if (redisUtil.hHasKey(UsRedisKeyConstant.IDEMPOTENCE_MAP, checker)) {
                    throw new UsBaseException(BaseBizsExceptionEnum.IDEMPOTENCE_INVALID);
                } else {
                    // 过期时间是一天
                    redisUtil.hset(UsRedisKeyConstant.IDEMPOTENCE_MAP, checker, checker, EXPIRATION_TIME);
                }
            }
        }

        return super.preHandle(request, response, handler);
    }

}
