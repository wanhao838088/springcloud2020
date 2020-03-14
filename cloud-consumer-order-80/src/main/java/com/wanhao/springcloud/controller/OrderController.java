package com.wanhao.springcloud.controller;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LiuLiHao on 2020/3/11 0011 上午 09:08
 * @author : LiuLiHao
 * 描述：
 */
@RestController
@RequestMapping(value = "consumer")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 基地址
     */
    private static final String BASE_URL = "http://CLOUD-PAYMENT-SERVICE/";

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping(value = "order/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id")String id){
        return restTemplate.getForObject(BASE_URL + "payment/" + id, CommonResult.class);
    }

    /**
     * 创建
     * @param payment
     * @return
     */
    @GetMapping(value = "order/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(BASE_URL + "payment/create",payment,CommonResult.class);
    }

}
