package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-09 14:14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer3344Main {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3344Main.class, args);
    }
}
