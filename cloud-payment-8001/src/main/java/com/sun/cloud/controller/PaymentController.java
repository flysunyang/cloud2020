package com.sun.cloud.controller;

import com.sun.cloud.bean.CommonResult;
import com.sun.cloud.bean.Payment;
import com.sun.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-24 23:14
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @GetMapping("/port")
    public String port() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "port: " + port;
    }

    @PostMapping("/add")
    public CommonResult<Integer> add(@RequestBody Payment payment) {
        Integer result = paymentService.addOne(payment);
        if(result > 0) {
            return new CommonResult<>(200, "新增成功", result);
        }
        return new CommonResult<>(500, "新增失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getById(id);
        if(payment == null) {
            return new CommonResult<>(400, "系统中订单表没有id为：" + id + "的数据");
        }
        return new CommonResult<>(200, port + "success", payment);
    }
}
