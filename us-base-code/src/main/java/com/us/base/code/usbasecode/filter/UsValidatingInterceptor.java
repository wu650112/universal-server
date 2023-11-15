package com.us.base.code.usbasecode.filter;

import com.us.base.code.usbasecode.filter.log.LogInterceptor;
import com.us.base.code.usbasecode.filter.token.LoginTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局拦截器
 *
 * @author wufan
 * @date 2023/8/30
 */
@Configuration
public class UsValidatingInterceptor extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginTokenInterceptor loginTokenInterceptor;

    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册Token拦截器
        registry.addInterceptor(loginTokenInterceptor)
                .addPathPatterns("/**");

        // 注册Log拦截器
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**");

        super.addInterceptors(registry);
    }

}
