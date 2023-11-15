package com.us.base.code.usbasecode.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分布式锁配置
 *
 * @author wufan
 * @date 2023/9/4
 */
@Configuration
@Slf4j
public class UsRedissonConfig {

    @Value("${spring.redisson.password}")
    private String redisPassword;

    @Value("${spring.redisson.single.server}")
    private String redisServer;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redisServer)
                .setPassword(redisPassword)
                // 设置数据库编号，如果需要的话
                .setDatabase(0);

        return Redisson.create(config);
    }

}
