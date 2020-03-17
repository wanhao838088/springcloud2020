package com.wanhao.springcloud;

/**
 * Created by LiuLiHao on 2020/3/17 0017 下午 05:39
 * @author : LiuLiHao
 * 描述：
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
