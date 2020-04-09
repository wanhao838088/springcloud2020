package com.wanhao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LiuLiHao on 2020/4/9 0009 上午 09:12
 * @author : LiuLiHao
 * 描述：路由编码配置方式
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置路由
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();

        builder.route("path_route_news_china",r->
                r.path("/guonei").uri("http://news.baidu.com/guonei"));

        builder.route("path_route_news_national",r->
                r.path("/guoji").uri("http://news.baidu.com/guoji"));

        builder.route("path_route_news_mil",r->
                r.path("/mil").uri("http://news.baidu.com/mil"));

        return builder.build();
    }
}
