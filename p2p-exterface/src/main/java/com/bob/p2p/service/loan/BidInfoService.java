package com.bob.p2p.service.loan;

import com.bob.p2p.model.loan.BidInfoExEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    /**
      *
      * @Description: 根据产品id 查询该产品的投资记录
      * @Author: bob
      * @Date: 2021/5/27 17:33
      * @version v1.0
      *
      */

    List<BidInfoExEntity> queryBidInfoListByLoanId(Integer id);
}
