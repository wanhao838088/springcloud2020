package com.wanhao.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * Created by LiuLiHao on 2020/4/28 0028 上午 09:16
 * @author : LiuLiHao
 * 描述：
 */
@EnableBinding(Source.class)
@Slf4j
public class IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    public String send(){
        String data = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(data).build());
        log.info("发送的消息: "+data);
        return null;
    }
}
