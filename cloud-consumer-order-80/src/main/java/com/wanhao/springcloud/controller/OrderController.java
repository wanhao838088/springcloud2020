package com.wanhao.springcloud.controller;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private static final String BASE_URL = "http://localhost:8001/";

    @GetMapping(value = "order/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id")String id){
        CommonResult<Payment> commonResult = restTemplate.getForObject(BASE_URL + "payment/" + id, CommonResult.class);
        return commonResult;
    }
}
