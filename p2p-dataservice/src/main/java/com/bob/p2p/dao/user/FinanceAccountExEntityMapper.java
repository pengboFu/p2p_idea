package com.bob.p2p.dao.user;


import com.bob.p2p.model.user.FinanceAccountExEntity;

import java.util.Map;

public interface FinanceAccountExEntityMapper {
    /**
      * 根据uid查询账户信息
      * @Description: 根据uid查询账户信息
      * @Author: bob
      * @Date: 2021/5/28 16:06
      * @version v1.0
      *
      */

    FinanceAccountExEntity selectFinanceAccountById(Integer uid);
    /**
      * 更新账户可用余额
      * @Description: 更新账户可用余额
      * @Author: bob
      * @Date: 2021/5/30 23:28
      * @version v1.0
      *
      */
    int updateFinanaceAccountByUid(Map<String, Object> paramMap);

    /**
      * 更新账户可用余额
      * @Description: TODO(一句话描述该类的功能)
      * @Author: bob
      * @Date: 2021/6/4 12:34
      * @version v1.0
      *
      */
    int updataFinanceAccountByIncomeBack(Map<String, Object> paramMap);
    /**
      * 更新账户余额
      * @Author: bob
      * @Date: 2021/6/6 11:44
      * @version v1.0
      *
      */
    int updateFinanaceAccountByRecharge(Map<String, Object> paramMap);
}