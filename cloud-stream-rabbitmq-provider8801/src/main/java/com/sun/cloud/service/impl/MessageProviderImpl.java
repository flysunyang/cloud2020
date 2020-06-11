package com.sun.cloud.service.impl;

import com.sun.cloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author zhaoyang
 * @description
 * @create 2020-06-10 18:02
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements MessageProvider {

    /**
     * 消息发送管道
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String sendMessage() {
        String uuid = UUID.randomUUID().toString();
        log.info(uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
        return "";
    }
}
