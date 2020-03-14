package com.wanhao.springcloud.dao;

import com.wanhao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 10:17
 * @author : LiuLiHao
 * 描述：数据库
 */
@Mapper
public interface PaymentDao {

    @Insert("INSERT INTO `payment`(serial) VALUES(#{serial});")
    int create(Payment payment);

    @Select("SELECT * FROM `payment` WHERE id=#{id}")
    Payment getById(@Param("id") Long id);

}
