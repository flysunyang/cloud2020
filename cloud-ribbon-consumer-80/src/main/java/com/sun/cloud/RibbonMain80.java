package com.sun.cloud;

import com.sun.cloud.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 10:50
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "PAYMENT-PROVIDER", configuration = MyRule.class)
public class RibbonMain80 {

    public static void main(String[] args) {
        SpringApplication.run(RibbonMain80.class, args);
    }
}
