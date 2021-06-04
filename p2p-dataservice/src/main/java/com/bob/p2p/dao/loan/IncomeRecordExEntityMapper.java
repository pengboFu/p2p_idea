package com.bob.p2p.dao.loan;

import com.bob.p2p.model.IncomeRecordEntity;

import java.util.List;

public interface IncomeRecordExEntityMapper {


    /**
      * 根据状态拿到获取收益记录
      * @Description: TODO(一句话描述该类的功能)
      * @Author: bob
      * @Date: 2021/6/4 12:30
      * @version v1.0
      *
      */
    List<IncomeRecordEntity> selectIncomeRecordByCurDateAndIncomeStatus(int status);
}