package com.bob.p2p.service.loan;


import org.springframework.stereotype.Service;

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
}
