package com.us.base.code.usbasecode.config;

import com.us.base.code.usbasecode.base.constant.UsThreadName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 全局线程池
 *
 * @author wufan
 * @date 2023/9/4
 */
@Configuration
@EnableAsync
@Slf4j
public class ThreadToolConfig {

    /**
     * 线程池1号
     */
    @Bean(UsThreadName.THREAD_POOR_ONE)
    public ThreadPoolExecutor threadPool() {
        // 获取当前机器的核数
        int cpuNum = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(cpuNum * 2, cpuNum * 4,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(
                Integer.MAX_VALUE),
                new ThreadPoolExecutor.CallerRunsPolicy());
        log.info("=====================================");
        log.info("=====================================");
        log.info("=====================================");
        log.info("   线程池UsThreadPoorOne初始化成功    ");
        log.info("=====================================");
        log.info("=====================================");
        log.info("=====================================");
        return executor;
    }
}
