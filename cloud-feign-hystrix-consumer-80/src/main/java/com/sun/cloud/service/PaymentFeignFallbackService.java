package com.sun.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-02 16:08
 */
@Component
public class PaymentFeignFallbackService implements PaymentFeignService {

    @Override
    public String success(Integer id) {
        return "我是success的fallback方法";
    }

    @Override
    public String timeout(Integer id) {
        return "我是timeout的fallback方法";
    }
}
