package com.bob.p2p.service.user;

import com.bob.p2p.dao.FinanceAccountEntityMapper;
import com.bob.p2p.dao.user.FinanceAccountExEntityMapper;
import com.bob.p2p.model.FinanceAccountEntity;
import com.bob.p2p.model.user.FinanceAccountExEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  *
  * @Description: 账户服务
  * @Author: bob
  * @Date: 2021/5/28 15:52
  * @version v1.0
  *
  */

@Service("financeAccountServiceImpl")
public class FinanceAccountServiceImpl implements FinanceAccountService{

    @Autowired
    private FinanceAccountEntityMapper financeAccountEntityMapper;

    @Autowired
    private FinanceAccountExEntityMapper financeAccountExEntityMapper;

    @Override
    public FinanceAccountExEntity queryFinanceAccountById(Integer uid) {
        return financeAccountExEntityMapper.selectFinanceAccountById(uid);
    }


}
