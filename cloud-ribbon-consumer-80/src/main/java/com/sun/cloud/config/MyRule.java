package com.sun.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author zhaoyang
 * @description 如果直接在主动类包下面注入IRule对象，则会替换掉所有的微服务对象
 * 如果仅需要处理某个微服务时，则需要在主启动类上只用@RibbonClient注解，并且不注入IRule对象，
 * 则可以实现对单个微服务的负载均衡定制
 * @create 2020-05-31 11:01
 */
public class MyRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
