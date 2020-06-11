package com.wanhao.springcloud.alibaba.dao;

import com.wanhao.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by LiuLiHao on 2020/6/10 0010 下午 03:15
 * @author : LiuLiHao
 * 描述：
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，从零改为1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
