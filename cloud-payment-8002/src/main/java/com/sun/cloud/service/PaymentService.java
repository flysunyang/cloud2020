package com.sun.cloud.service;

import com.sun.cloud.bean.Payment;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-24 23:13
 */
public interface PaymentService {

    Integer addOne(Payment payment);

    Payment getById(Integer id);
}
