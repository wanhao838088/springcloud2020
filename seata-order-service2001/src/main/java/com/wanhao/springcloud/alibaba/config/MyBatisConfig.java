package com.wanhao.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LiuLiHao on 2020/6/10 0010 下午 03:23
 * @author : LiuLiHao
 * 描述：
 */
@Configuration
@MapperScan({"com.wanhao.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
