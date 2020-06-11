package com.wanhao.springcloud.alibaba.service;

import com.wanhao.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by LiuLiHao on 2020/6/10 0010 下午 03:26
 *
 * @author : LiuLiHao
 * 描述：
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId
            , @RequestParam("count") Integer count);

}

