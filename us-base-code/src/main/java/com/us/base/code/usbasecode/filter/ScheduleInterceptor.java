package com.us.base.code.usbasecode.filter;

import com.us.base.code.usbasecode.base.constant.UsRedisKeyConstant;
import com.us.base.code.usbasecode.base.enums.BaseBizsExceptionEnum;
import com.us.base.code.usbasecode.base.exception.UsBaseException;
import com.us.base.code.usbasecode.util.UsRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务拦截器，在每个定时任务启动的时候先去redis判断这个定时任务该不该启动
 *
 * @author wufan
 * @date 2024/1/17
 */
@Aspect
@Component
@Slf4j
public class ScheduleInterceptor {

    @Autowired
    private UsRedisUtil redisUtil;

    @Before("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public void beforeScheduledTask(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        log.warn("定时任务：" + methodName + "请求执行");
        if (redisUtil.hHasKey(UsRedisKeyConstant.US_TASK_AUTH, methodName)) {
            redisUtil.hincr(UsRedisKeyConstant.US_TASK_AUTH, methodName, 1);
        } else {
            throw new UsBaseException(BaseBizsExceptionEnum.CAN_NOT_EXECUTE);
        }
    }
}
