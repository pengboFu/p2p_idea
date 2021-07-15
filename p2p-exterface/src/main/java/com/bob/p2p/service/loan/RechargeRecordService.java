package com.bob.p2p.service.loan;

import com.bob.p2p.model.RechargeRecordEntity;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.RechargeRecordExEntity;

import java.util.List;
import java.util.Map;

/**
  * 充值记录
  * @Description: TODO(一句话描述该类的功能)
  * @Author: bob
  * @Date: 2021/6/4 21:09
  * @version v1.0
  *
  */
public interface RechargeRecordService {

    /**
      * 增加充值记录
      * @Description:
      * @Author: bob
      * @Date: 2021/6/4 21:10
      * @version v1.0
      *
     * @param rechargeRecordEntity
     */
    int addRechargeRecord(RechargeRecordEntity rechargeRecordEntity);
    /**
      * 用户充值记录 带分页
      * @Author: bob
      * @Date: 2021/6/4 22:56
      * @version v1.0
      *
      */
    List<RechargeRecordExEntity> queryRechargeRecordListTopByUid(Map<String, Object> paramMap);
    /**
      * 查询用户充值记录 展示页
      * @Author: bob
      * @Date: 2021/6/5 1:01
      * @version v1.0
      *
      */
    PagenationVO<RechargeRecordExEntity> queryRechargeRecordListByUid(Map<String, Object> paramMap);
    /**
      * 更新充值状态根据充值订单号
      * @Author: bob
      * @Date: 2021/6/6 11:22
      * @version v1.0
      *
     * @param rechargeRecordEntity
     */
    int modifyRechargeRecordByRecordNo(RechargeRecordEntity rechargeRecordEntity);
    /**
      *用户充值
      * @Author: bob
      * @Date: 2021/6/6 11:35
      * @version v1.0
      *
      */
    int recharge(Map<String, Object> paramMap);
}
