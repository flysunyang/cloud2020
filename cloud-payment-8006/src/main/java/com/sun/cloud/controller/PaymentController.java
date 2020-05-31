package com.sun.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-29 11:12
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    ServerProperties serverProperties;

    @GetMapping("/consul/port")
    public String port() {
        return "我是consul：" + serverProperties.getPort();
    }
}
