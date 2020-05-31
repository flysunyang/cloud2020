package com.sun.cloud.service.impl;

import com.sun.cloud.bean.Payment;
import com.sun.cloud.mapper.PaymentMapper;
import com.sun.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-24 23:14
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public Integer addOne(Payment payment) {
        return paymentMapper.insertOne(payment);
    }

    @Override
    public Payment getById(Integer id) {
        return paymentMapper.selectById(id);
    }
}
