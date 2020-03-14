package com.wanhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 09:28
 * @author : LiuLiHao
 * 描述：启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8004.class,args);
    }

}
