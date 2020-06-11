package com.sun.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-09 16:40
 */
@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigClientController {

    @Value("${config.name}")
    String configName;

    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/client")
    public String clientMsg() {
        return configName;
    }

    @GetMapping("/appname")
    public String appName() {
        return applicationName;
    }
}
