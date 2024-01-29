package com.us.bizs.controller;

import com.alibaba.fastjson.JSONObject;
import com.us.base.code.usbasecode.base.dao.UsBaseRespResult;
import com.us.base.code.usbasecode.base.enums.BaseBizsExceptionEnum;
import com.us.base.code.usbasecode.base.exception.UsBaseException;
import com.us.base.code.usbasecode.util.RedissonLocker;
import com.us.base.code.usbasecode.util.UsThreadExecutor;
import com.us.bizs.dao.dto.LoginDTO;
import com.us.bizs.service.UsUserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 基础服务
 * 包括用户&权限等操作
 *
 * @author admin
 * @date 2023/7/21
 */
@RestController
@RequestMapping("/us")
@Slf4j
public class BaseInfoController {

    @Autowired
    private UsUserService usUserService;

    @Autowired
    private RedissonLocker locker;

    /**
     * 登录接口
     */
    @PostMapping("/login")
    public UsBaseRespResult<String> getAppointmentWashServiceOrderList(@RequestBody LoginDTO userLogin) {
        return UsBaseRespResult.success(usUserService.login(userLogin));
    }

    @PostMapping("/test")
    public UsBaseRespResult<String> fakerTest(@RequestBody JSONObject jsonObject) {
        String locket = jsonObject.getString("key");
        if (locker.isLocked(locket)) {
            throw new UsBaseException(BaseBizsExceptionEnum.WAITING_UNLOCK);
        }
        RLock lock = locker.lock(String.valueOf(locket));
        // 加锁
        try {
            System.out.println("加锁成功，执行后续代码。线程 ID：" + Thread.currentThread().getId());
            Thread.sleep(5000);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new UsBaseException(BaseBizsExceptionEnum.WAITING_UNLOCK);
        } finally {
            lock.unlock();
            // 解锁
            System.out.println("Finally，释放锁成功。线程 ID：" + Thread.currentThread().getId());
        }
        return UsBaseRespResult.success("1");
    }

    private static final Lock REENTRANT_LOCK = new ReentrantLock();


    @PostMapping("/test2")
    public UsBaseRespResult<Integer> fakerTest2(@RequestBody JSONObject jsonObject) {
        usUserService.test();
        return UsBaseRespResult.success(1);
    }

}
