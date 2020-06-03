package com.wanhao.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wanhao.springcloud.alibaba.handler.CustomBlockHandler;
import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiuLiHao on 2020/6/2 0002 上午 09:18
 * @author : LiuLiHao
 * 描述：
 */
@RestController
@Slf4j
public class RateLimitController {


    /**
     * 按照资源名，使用外部类限流
     * @return
     */
    @GetMapping(value = "/rate/testCustom")
    @SentinelResource(value = "testCustom"
            , blockHandlerClass = CustomBlockHandler.class
            ,blockHandler = "handlerException2")
    public CommonResult testCustom(){
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }

}
