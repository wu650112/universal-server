package com.us.bizs.task;

import com.alibaba.fastjson.JSONObject;
import com.us.base.code.usbasecode.util.UsRedisUtil;
import com.us.bizs.constant.GoMsgKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给go项目那边的代码通知，用redis做桥梁
 *
 * @author wufan
 * @date 2024/1/17
 */
@Component
@Slf4j
public class GoGetInfoTask {

    private static final AtomicInteger integer = new AtomicInteger();

    @Autowired
    private UsRedisUtil redisUtil;

    @Scheduled(cron = "0/5 * * * * *")
    public void doSendRedisMsg() {
        log.info("执行了{}次", integer.addAndGet(1));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("time", System.currentTimeMillis());
        jsonObject.put("from", "doSendRedisMsg");
        jsonObject.put("msg", "你好啊！go");
        redisUtil.lSet(GoMsgKeyConstant.GO_MSG, jsonObject.toJSONString());
    }
}
