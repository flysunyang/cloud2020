package com.sun.cloud.service;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-01 10:43
 */
public interface PaymentService {

    String success(Integer id);

    String timeout(Integer id);

    String circuit(Integer id);
}
