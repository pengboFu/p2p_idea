package com.bob.p2p.service.loan;

import org.springframework.stereotype.Service;

/**
  *
  * @Description: 投资服务
  * @Author: bob
  * @Date: 2021/5/26 10:51
  * @version v1.0
  *
  */
@Service
public interface BidInfoService {

    /**
      *
      * @Description: 查询平台所有投资金额
      * @Author: bob
      * @Date: 2021/5/26 10:53
      * @version v1.0
      *
      */
    Double queryAllBidMoney();
}
