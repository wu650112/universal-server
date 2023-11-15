package com.us.base.code.usbasecode.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 校验登录
 *
 * @author wufan
 * @date 2023/7/21
 */
@Aspect
@Component
@RequiredArgsConstructor
public class CheckLoginAspect {

//    @Autowired
//    private UsRedisUtil usRedisUtil;
//
//    @Pointcut("@annotation(needToken)")
//    public void pointcut(NeedToken needToken) {
//    }
//
//
//    @Before("pointcut(needToken)")
//    public void beforeMethod(JoinPoint joinPoint, NeedToken needToken) {
//        // 获取RequestAttributes
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        // 从获取RequestAttributes中获取HttpServletRequest的信息
//        assert requestAttributes != null;
//        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//        if (request == null) {
//            throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_EXPIRED);
//        }
//        String token = request.getHeader("Authorization");
//        if (StringUtils.hasText(token)) {
//            throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_EXPIRED);
//        }
//        // 判断redis中的token是否过期
//        Object obj = usRedisUtil.get("token");
//        if (obj == null) {
//            throw new UsBaseException(BaseBizsExceptionEnum.TOKEN_EXPIRED);
//        }
//    }

}
