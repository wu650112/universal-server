package com.us.bizs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author admin
 */
@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = {"com.us"})
@MapperScan("com.us.bizs.dao.mapper")
public class UsBizsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsBizsApplication.class, args);
    }

}
