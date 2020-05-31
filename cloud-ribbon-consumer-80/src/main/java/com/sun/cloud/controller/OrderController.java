package com.sun.cloud.controller;

import com.sun.cloud.bean.CommonResult;
import com.sun.cloud.bean.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 10:51
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String SERVICE_NAME = "http://PAYMENT-PROVIDER";

    private static final String EXPRESS_SERVICE = "http://EXPRESS-PROVIDER";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/express/port")
    public String expressPort() {
        return restTemplate.getForObject(EXPRESS_SERVICE + "/express/port", String.class);
    }

    @GetMapping("/payment/port")
    public String port() {
        return restTemplate.getForObject(SERVICE_NAME + "/payment/port", String.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(SERVICE_NAME + "/payment/get/" + id, CommonResult.class);
    }
}
