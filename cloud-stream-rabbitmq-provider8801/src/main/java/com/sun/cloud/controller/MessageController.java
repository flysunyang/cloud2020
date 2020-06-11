package com.sun.cloud.controller;

import com.sun.cloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-10 18:09
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageProvider messageProvider;

    @GetMapping("/provider")
    public String provider() {
        return messageProvider.sendMessage();
    }
}
