package com.sun.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-29 11:23
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String SERVICE_NAME = "http://payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul/port")
    public String port() {
        return restTemplate.getForObject(SERVICE_NAME + "/payment/consul/port", String.class);
    }
}
