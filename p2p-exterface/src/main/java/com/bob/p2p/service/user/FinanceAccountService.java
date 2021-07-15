package com.bob.p2p.service.user;

import com.bob.p2p.model.FinanceAccountEntity;
import com.bob.p2p.model.user.FinanceAccountExEntity;
import org.springframework.stereotype.Service;

/**
  *
  * @Description: 账户信息服务
  * @Author: bob
  * @Date: 2021/5/28 15:48
  * @version v1.0
  *
  */
public interface FinanceAccountService {

    /**
      *
      * @Description: 根据用户id查询账户信息
      * @Author: bob
      * @Date: 2021/5/28 15:49
      * @version v1.0
      *
      */
    FinanceAccountExEntity queryFinanceAccountById(Integer uid);
}
