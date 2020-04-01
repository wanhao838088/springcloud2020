package com.wanhao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by LiuLiHao on 2020/4/1 0001 上午 09:08
 * @author : LiuLiHao
 * 描述：fallback解耦
 */
@Component
public class PaymentFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfoOK(Integer id) {
        return "Fallback  paymentInfoOK";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "Fallback  paymentInfoTimeOut";
    }
}
