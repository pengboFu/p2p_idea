package com.bob.p2p.dao.loan;


import com.bob.p2p.model.RechargeRecordEntity;
import com.bob.p2p.model.loan.RechargeRecordExEntity;

import java.util.List;
import java.util.Map;

public interface RechargeRecordExEntityMapper {
    /**
      *查询用户充值记录
      * @Author: bob
      * @Date: 2021/6/4 23:08
      * @version v1.0
      *
      */
    List<RechargeRecordExEntity> selectRechargeRecordListByUid(Map<String, Object> paramMap);
    /**
      *查询用户总投资记录数
      * @Author: bob
      * @Date: 2021/6/5 1:04
      * @version v1.0
      *
      */
    Long selectRechargeRecordByUidTotal(String uid);
    /**
      *更新充值状态根据充值订单号
      * @Author: bob
      * @Date: 2021/6/6 11:24
      * @version v1.0
      *
      */
    int updateRechargeRecordByRecordNo(RechargeRecordEntity rechargeRecordEntity);
}
