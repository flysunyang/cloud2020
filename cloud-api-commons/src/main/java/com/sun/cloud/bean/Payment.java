package com.sun.cloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-24 22:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    
    private Integer id;

    private String serial;
    
}
