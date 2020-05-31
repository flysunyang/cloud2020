package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 11:17
 */
@SpringBootApplication
@EnableEurekaClient
public class ExpressMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(ExpressMain9001.class, args);
    }
}
