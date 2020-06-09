package com.sun.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-02 10:24
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String PAYMENT_SERVICE = "http://HYSTRIX-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/payment/success/{id}")
    public String get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/success/" + id, String.class);
    }

    @GetMapping("/payment/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String timeout(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/timeout/" + id, String.class);
    }

    public String timeoutFallBack(Integer id) {
        return "我是服务消费端, 线程：" + Thread.currentThread().getName() + "调用timeout方法出错";
    }
}
