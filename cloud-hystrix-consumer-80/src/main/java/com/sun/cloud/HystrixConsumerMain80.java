package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-02 10:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerMain80.class, args);
    }
}
