package com.wanhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by LiuLiHao on 2020/3/11 0011 上午 09:07
 * @author : LiuLiHao
 * 描述：
 */
@SpringBootApplication
@EnableEurekaClient
public class MainApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication80.class,args);
    }
}
