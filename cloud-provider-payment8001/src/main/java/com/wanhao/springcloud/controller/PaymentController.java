package com.wanhao.springcloud.controller;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import com.wanhao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 10:22
 * @author : LiuLiHao
 * 描述：基础增删改查测试
 */
@RestController
@Slf4j
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    /**
     * 获取服务列表
     * @return
     */
    @GetMapping(value = "getDiscoveryClient")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        log.error("-------服务列表--------");

        for (String service : services) {
            log.error(service);
        }
        log.error("-------实例列表--------");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.error(instance.getInstanceId() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }
    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return port;
    }

    /**
     * 暂停3秒钟返回
     * @return
     */
    @GetMapping(value = "pause")
    public String pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
