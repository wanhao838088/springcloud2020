package com.wanhao.springcloud.controller;

import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import com.wanhao.springcloud.loadbalance.MyLB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLB lb;
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

    /**
     * 自己实现负载
     * @return
     */
    @GetMapping(value = "loadBalance")
    public String loadBalance(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = lb.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
