package com.sun.cloud.controller;

import com.sun.cloud.bean.CommonResult;
import com.sun.cloud.bean.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-25 10:49
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    private static final String URL = "http://127.0.0.1:8001";

    private static final String SERVICE_NAME = "http://PAYMENT-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        discoveryClient.getServices().stream().forEach(System.out::println);
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t"
            + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/port")
    public String port() {
        return restTemplate.getForObject(SERVICE_NAME + "/payment/port", String.class);
    }

    @GetMapping("/add")
    public CommonResult<Integer> add(Payment payment) {
        // return restTemplate.postForObject(URL + "/add", payment, CommonResult.class);
        return restTemplate.postForObject(SERVICE_NAME + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> add(@PathVariable("id") Integer id) {
        // return restTemplate.getForObject(URL + "/get/" + id, CommonResult.class);
        return restTemplate.getForObject(SERVICE_NAME + "/payment/get/" + id, CommonResult.class);
    }
}
