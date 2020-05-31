package com.sun.cloud.controller;

import com.sun.cloud.bean.CommonResult;
import com.sun.cloud.bean.Payment;
import com.sun.cloud.feign.FeignPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 14:37
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    FeignPaymentService feignPaymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id) {
        return feignPaymentService.get(id);
    }

    @GetMapping("/port")
    public String port() {
        return feignPaymentService.port();
    }
}
