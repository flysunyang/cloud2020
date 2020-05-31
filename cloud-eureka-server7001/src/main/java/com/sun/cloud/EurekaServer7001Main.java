package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-25 17:15
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Main {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Main.class, args);
    }
}
