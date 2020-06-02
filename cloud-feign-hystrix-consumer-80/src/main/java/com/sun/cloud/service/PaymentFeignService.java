package com.sun.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-02 11:29
 */
@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFeignFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/success/{id}")
    public String success(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id);

}
