package com.wanhao.springcloud.alibaba.service.impl;


import com.wanhao.springcloud.alibaba.dao.AccountDao;
import com.wanhao.springcloud.alibaba.service.AccountService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        String xid = RootContext.getXID();
        LOGGER.info("xid    "+xid);
        //不知道为啥 不解绑从新绑定会导致找不到xid...
        RootContext.unbind();
        RootContext.bind(xid);
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
