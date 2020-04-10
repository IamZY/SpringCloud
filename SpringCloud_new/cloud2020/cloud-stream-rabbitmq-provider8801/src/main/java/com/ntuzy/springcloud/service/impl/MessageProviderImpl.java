package com.ntuzy.springcloud.service.impl;

import com.ntuzy.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author IamZY
 * @create 2020/4/9 9:49
 */
@EnableBinding(Source.class)  // 定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {
        String str = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(str).build());
        System.out.println("************str: " + str);
        return str;
    }
}
