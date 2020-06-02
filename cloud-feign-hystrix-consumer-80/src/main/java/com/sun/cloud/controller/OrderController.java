package com.sun.cloud.controller;

import com.sun.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-02 11:30
 */
@RestController
@RequestMapping("/consumer")
// @DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/payment/success/{id}")
    // @HystrixCommand
    // @HystrixCommand(fallbackMethod = "successFall", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    // })
    public String success(@PathVariable("id") Integer id) {
        // int i = 9 / 0;
        return paymentFeignService.success(id);
    }

    @GetMapping("/payment/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "successFall", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000")
    // })
    public String timeout(@PathVariable("id") Integer id) {
        return paymentFeignService.timeout(id);
    }

    public String successFall(@PathVariable("id") Integer id) {
        return "this is default fallback method!!!" + id;
    }

    public String defaultFallBack() {
        return "当前服务超时或不可用，请稍后再试！";
    }
}
