package com.wanhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 09:28
 * @author : LiuLiHao
 * 描述：启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class MainApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8001.class,args);
    }

}
