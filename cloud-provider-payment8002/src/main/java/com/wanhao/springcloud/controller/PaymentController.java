package com.wanhao.springcloud.controller;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import com.wanhao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 10:22
 * @author : LiuLiHao
 * 描述：基础增删改查测试
 */
@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "create")
    public CommonResult<Payment> create(Payment payment){
        int i = paymentService.create(payment);
        if (i>0){
            return new CommonResult<>(CommonResult.success,"操作成功");
        }
        return new CommonResult<>(CommonResult.error,"操作失败");
    }

    @GetMapping(value = "{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){
        Payment payment = paymentService.getById(id);
        if (payment!=null){
            return new CommonResult<>(CommonResult.success,"查询成功,端口号:"+port,payment);
        }
        return new CommonResult<>(CommonResult.error,"没有记录");
    }
}
