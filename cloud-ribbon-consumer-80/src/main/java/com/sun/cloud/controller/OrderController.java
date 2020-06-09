package com.sun.cloud.controller;

import com.sun.cloud.bean.CommonResult;
import com.sun.cloud.bean.Payment;
import com.sun.cloud.loadbalance.MySelfLoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    MySelfLoadBalance mySelfLoadBalance;

    @GetMapping("/loadbalance")
    public String loadbalance() {
        // 获取某个微服务所有的服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");
        ServiceInstance instance = mySelfLoadBalance.choose(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/port", String.class);
    }

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
