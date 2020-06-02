package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-02 11:28
 */
@SpringBootApplication
@EnableFeignClients
// feign中调用Hystrix使用该注解
@EnableHystrix
public class FeignHystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class, args);
    }
}
