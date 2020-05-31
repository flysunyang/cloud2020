package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-29 11:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8006Main.class, args);
    }
}
