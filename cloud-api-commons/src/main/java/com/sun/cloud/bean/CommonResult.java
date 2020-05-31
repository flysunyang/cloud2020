package com.sun.cloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-24 22:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T t;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
