package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-28 22:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkConsumerMain80 {
    
    public static void main(String[] args) {
        SpringApplication.run(ZkConsumerMain80.class, args);
    }
}
