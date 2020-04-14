package com.wanhao.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * Created by LiuLiHao on 2020/4/14 0014 上午 09:02
 * @author : LiuLiHao
 * 描述：gateway过滤器
 */
@Component
@Slf4j
public class LogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("***********进入过滤器:  "+new Date());

        String name = exchange.getRequest().getQueryParams().getFirst("name");

        if(name == null) {
            log.info("*******用户名为null，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    /**
     * 数字越小 优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
