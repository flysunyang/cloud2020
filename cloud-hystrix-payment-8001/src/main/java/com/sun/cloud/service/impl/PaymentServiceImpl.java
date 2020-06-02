package com.sun.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-01 10:43
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String success(Integer id) {
        return Thread.currentThread().getName() + "success: " + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeoutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") // hystrix 调用超时时间
    })
    public String timeout(Integer id) {
        // int i = 10 / 0;
        int time = 2;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "暂停(秒)：" + time + "timeout: " + id;
    }

    @HystrixCommand(fallbackMethod = "timeoutFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    @Override
    public String circuit(Integer id) {
        if(id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public String timeoutFallBack(Integer id) {
        return "线程：" + Thread.currentThread().getName() + "调用timeout方法出错";
    }
}
