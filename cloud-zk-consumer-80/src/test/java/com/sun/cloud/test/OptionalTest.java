package com.sun.cloud.test;

import java.util.Optional;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-29 9:15
 */
public class OptionalTest {

    public static void main(String[] args) {
        String str = null;
        Optional<String> optional = Optional.ofNullable(str);
        String result = optional.orElseThrow(() ->
                new RuntimeException("str不能为空"));
        System.out.println(result);
    }
}
