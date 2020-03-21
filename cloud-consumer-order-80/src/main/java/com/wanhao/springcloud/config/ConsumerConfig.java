package com.wanhao.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LiuLiHao on 2020/3/11 0011 上午 09:09
 * @author : LiuLiHao
 * 描述：配置文件
 */
@Configuration
public class ConsumerConfig {

    /**
     * RestTemplate
     * @return
     */
    @Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
