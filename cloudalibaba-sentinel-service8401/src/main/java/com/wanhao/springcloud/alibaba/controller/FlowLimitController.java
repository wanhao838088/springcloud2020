package com.wanhao.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wanhao.springcloud.alibaba.handler.CustomBlockHandler;
import com.wanhao.springcloud.entities.CommonResult;
import com.wanhao.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by LiuLiHao on 2020/5/15 0015 上午 09:10
 *
 * @author : LiuLiHao
 * 描述：
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }


    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
//        log.info("testD 异常比例");
//        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {

        return "------testHotKey";
    }

    /**
     * 处理降级的方法
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

}
