package com.bob.p2p.dao.loan;

import com.bob.p2p.model.IncomeRecordEntity;
import com.bob.p2p.model.loan.IncomeRecordExEntity;

import java.util.List;
import java.util.Map;

public interface IncomeRecordExEntityMapper {


    /**
      * 根据状态拿到获取收益记录
      * @Description:
      * @Author: bob
      * @Date: 2021/6/4 12:30
      * @version v1.0
      *
      */
    List<IncomeRecordEntity> selectIncomeRecordByCurDateAndIncomeStatus(int status);
    /**
     * 查询用户收益记录 带分页
     * @Description:
     * @Author: bob
     * @Date: 2021/6/4 12:30
     * @version v1.0
     *
     */
    List<IncomeRecordExEntity> selectIncomeRecordTopByUid(Map<String, Object> paramMap);
    /**
      *查询所有用户收益记录
      * @Author: bob
      * @Date: 2021/6/5 1:22
      * @version v1.0
      *
      */
    Long selectIncomeRecordByUidTotal(String uid);
}