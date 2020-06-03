package com.wanhao.springcloud.alibaba.service;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by LiuLiHao on 2020/6/3 0003 上午 09:28
 * @author : LiuLiHao
 * 描述：
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}

