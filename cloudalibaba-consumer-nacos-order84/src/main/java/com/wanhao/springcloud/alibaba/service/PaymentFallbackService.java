package com.wanhao.springcloud.alibaba.service;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * Created by LiuLiHao on 2020/6/3 0003 上午 09:29
 * @author : LiuLiHao
 * 描述：
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
