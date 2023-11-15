package com.us.base.code.usbasecode.util;

import com.us.base.code.usbasecode.base.constant.UsThreadName;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程工具类
 *
 * @author wufan
 * @date 2023/9/5
 */
@Slf4j
public class UsThreadExecutor {

    /**
     * 线程池
     */
    private static ThreadPoolExecutor executor;

    public UsThreadExecutor() {

    }

    static {
        init();
    }

    /**
     * 初始化全局线程池
     */
    synchronized public static void init() {
        // 初始化线程池
        if (executor == null) {
            executor = (ThreadPoolExecutor) ApplicationContextUtil.getBean(UsThreadName.THREAD_POOR_ONE);
        }
    }

    /**
     * 执行有返回值的异步方法<br>
     * Future代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，则，get()会使当前线程阻塞
     *
     * @param runnable 可运行对象
     * @return {@link Future}
     */
    public static Future<?> submit(Runnable runnable) {
        return executor.submit(runnable);
    }


}
