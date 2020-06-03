package com.wanhao.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wanhao.springcloud.entities.CommonResult;

/**
 * Created by LiuLiHao on 2020/6/2 0002 上午 09:04
 *
 * @author : LiuLiHao
 * 描述：
 */
public class CustomBlockHandler {
    /**
     * 通用处理1
     * @param exception
     * @return
     */
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(500, "按客戶自定义,global handlerException----1");
    }

    /**
     * 通用处理2
     * @param exception
     * @return
     */
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(500, "按客戶自定义,global handlerException----2");
    }
}
