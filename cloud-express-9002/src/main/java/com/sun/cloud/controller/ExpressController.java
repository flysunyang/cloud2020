package com.sun.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 11:18
 */
@RestController
@RequestMapping("/express")
public class ExpressController {

    @Value("${server.port}")
    String port;

    @GetMapping("/port")
    public String port() {
        return "express: " + port;
    }
}
