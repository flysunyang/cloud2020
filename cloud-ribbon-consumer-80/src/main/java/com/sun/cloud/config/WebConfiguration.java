package com.sun.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 10:52
 */
@Configuration
public class WebConfiguration {

    @Bean
    // @LoadBalanced 自定义负载均衡规则的时候去除该注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
