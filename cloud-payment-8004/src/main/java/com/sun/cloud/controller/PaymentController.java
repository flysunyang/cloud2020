package com.sun.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-28 22:03
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/zk")
    public String zk() {
        return "this is zookeeper";
    }
}
