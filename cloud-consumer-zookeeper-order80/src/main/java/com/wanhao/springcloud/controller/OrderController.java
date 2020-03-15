package com.wanhao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LiuLiHao on 2020/3/15 0015 上午 10:55
 * @author : LiuLiHao
 * 描述：测试调用远程服务
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PREFIX = "http://cloud-payment-service/";

    @GetMapping(value = "call")
    public String call(){
        return restTemplate.getForObject(PREFIX+"payment/zk",String.class);
    }
}
