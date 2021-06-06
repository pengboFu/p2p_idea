package com.bob.p2p.service.loan;


import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.IncomeRecordExEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
  *
  * 定时器处理
  * @Author: bob
  * @Date: 2021/5/31 13:27
  * @version v1.0
  *
  */
public interface IncomRecordService {

    /**
      *
      * 生成收益
      * @Author: bob
      * @Date: 2021/5/31 13:28
      * @version v1.0
      *
      */
    void ganarateIncomePlan();

    /**
      * 收益返还
      * @Description:
      * @Author:
      * @Date: 2021/5/31 19:58
      * @version v1.0
      *
      */
    void generateIncomeBack();
    /**
      * 用户最近收益 带分页
      * @Author: bob
      * @Date: 2021/6/4 23:14
      * @version v1.0
      *
      */
    List<IncomeRecordExEntity> queryIncomRecordListTopByUid(Map<String, Object> paramMap);
    /**
      *查看用户全部收益
      * @Author: bob
      * @Date: 2021/6/5 1:20
      * @version v1.0
      *
      */
    PagenationVO<IncomeRecordExEntity> queryIncomeRecordListByUid(Map<String, Object> paramMap);
}
