package com.sun.cloud.feign;

import com.sun.cloud.bean.CommonResult;
import com.sun.cloud.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 14:36
 */
@FeignClient(value = "PAYMENT-PROVIDER")
public interface FeignPaymentService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id);

    @GetMapping("/payment/port")
    public String port();
}
