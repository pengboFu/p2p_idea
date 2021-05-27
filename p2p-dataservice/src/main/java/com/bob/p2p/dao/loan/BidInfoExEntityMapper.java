package com.bob.p2p.dao.loan;

import com.bob.p2p.model.loan.BidInfoExEntity;

import java.util.List;

public interface BidInfoExEntityMapper {

    /**
      *
      * @Description: 查询平台注册总金额
      * @Author: bob
      * @Date: 2021/5/27 13:23
      * @version v1.0
      *
      */

    Double selectALlBidMoney();
    /**
      *
      * @Description: 根据产品id查询投资记录
      * @Author: bob
      * @Date: 2021/5/27 17:36
      * @version v1.0
      *
      */

    List<BidInfoExEntity> selectBidInfoListByLoanId(Integer id);
}
