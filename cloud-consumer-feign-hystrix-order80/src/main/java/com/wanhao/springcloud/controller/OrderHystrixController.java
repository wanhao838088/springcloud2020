package com.wanhao.springcloud.controller;

import com.wanhao.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by LiuLiHao on 2020/3/27 0027 上午 09:18
 * @author : LiuLiHao
 * 描述：
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod",commandProperties = {
//        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//})
@RequestMapping(value = "consumer/payment/hystrix/")
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        return orderHystrixService.paymentInfoOK(id);
    }

    @GetMapping("timeout/{id}")
    //@HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        //int age = 10/0;
        return orderHystrixService.paymentInfoTimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 全局fallback方法
     *
     * @return
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
