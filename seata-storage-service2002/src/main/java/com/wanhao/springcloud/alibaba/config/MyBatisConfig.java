package com.wanhao.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.wanhao.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
