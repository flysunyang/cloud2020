package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 10:50
 */
@SpringBootApplication
@EnableEurekaClient
// @RibbonClient(value = "PAYMENT-PROVIDER", configuration = MyRule.class)
@EnableDiscoveryClient
public class RibbonMain80 {

    public static void main(String[] args) {
        SpringApplication.run(RibbonMain80.class, args);
    }
}
