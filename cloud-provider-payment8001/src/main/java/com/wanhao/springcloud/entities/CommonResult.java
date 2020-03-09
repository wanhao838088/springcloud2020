package com.wanhao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 10:15
 * @author : LiuLiHao
 * 描述：传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public static int success = 0;
    public static int error = 500;

    public CommonResult(int code ,String messsage){
        this(code,messsage,null);
    }

}
