package com.sun.cloud.controller;

import com.sun.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-01 10:46
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/success/{id}")
    public String success(@PathVariable("id") Integer id) {
        log.info("-----------success");
        return paymentService.success(id);
    }

    @GetMapping("/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        log.info("-----------timeout");
        return paymentService.timeout(id);
    }

    @GetMapping("/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id) {
        log.info("-----------circuit");
        return paymentService.circuit(id);
    }
}
