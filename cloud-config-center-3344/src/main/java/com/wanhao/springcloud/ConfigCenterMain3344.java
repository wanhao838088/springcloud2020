package com.wanhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 访问方式 http://localhost:3344/master/config-dev.yml
 * @author Administrator
 * 刷新配置 curl -X POST  http://localhost:3344/actuator/bus-refresh
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
            SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
