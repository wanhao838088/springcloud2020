package com.wanhao.springcloud.controller;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiuLiHao on 2020/4/28 0028 上午 09:29
 * @author : LiuLiHao
 * 描述：
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 接受消息
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号,----->接受到的消息: "+
                message.getPayload()+"\t  port: "+serverPort);
    }
}
