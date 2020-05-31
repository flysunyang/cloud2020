package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-29 11:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerMain80.class, args);
    }
}
