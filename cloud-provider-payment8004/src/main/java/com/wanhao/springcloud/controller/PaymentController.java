package com.wanhao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by LiuLiHao on 2020/3/14 0014 下午 09:27
 * @author : LiuLiHao
 * 描述：
 */
@RestController
@Slf4j
@RequestMapping(value = "payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "zk")
    public String payment(){
        return "zookeeper: "+port + UUID.randomUUID().toString();
    }

}
