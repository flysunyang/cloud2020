package com.sun.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 19:22
 */
@Configuration
public class FooConfiguration {

    /**
     * openfeign的日志级别bean
     */
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
