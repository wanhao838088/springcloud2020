package com.wanhao.springcloud.service;

import com.wanhao.springcloud.dao.PaymentDao;
import com.wanhao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuLiHao on 2020/3/8 0008 下午 10:20
 * @author : LiuLiHao
 * 描述：service
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getById( Long id){
        return paymentDao.getById(id);
    }


}
