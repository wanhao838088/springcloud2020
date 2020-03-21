package com.wanhao.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LiuLiHao on 2020/3/21 0021 上午 11:09
 * @author : LiuLiHao
 * 描述：替换ribbon的负载
 */
@Configuration
public class ProjectRule {

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
