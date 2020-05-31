package com.sun.cloud.mapper;

import com.sun.cloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-24 23:04
 */
@Mapper
public interface PaymentMapper {

    public Integer insertOne(Payment payment);

    public Payment selectById(Integer id);
}
