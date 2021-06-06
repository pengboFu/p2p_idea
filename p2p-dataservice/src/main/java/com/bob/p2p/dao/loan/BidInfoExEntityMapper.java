package com.bob.p2p.dao.loan;

import com.bob.p2p.model.loan.BidInfoExEntity;

import java.util.List;
import java.util.Map;

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
    /**
      *根据产品id获取投资记录表
      * @Description:
      * @Author: bob
      * @Date: 2021/5/31 13:44
      * @version v1.0
      *
      */
    List<BidInfoExEntity> selectBidInfoByLoanId(Integer loanId);
    /**
     *根据用户id获取投资记录  带分页
     * @Description:
     * @Author: bob
     * @Date: 2021/5/31 13:44
     * @version v1.0
     *
     */
    List<BidInfoExEntity> selectBidInfoListTop(Map<String, Object> paramMap);
    /**
      *查询用户总投资记录
      * @Author: bob
      * @Date: 2021/6/5 0:46
      * @version v1.0
      *
      */
    Long selectBidInfoByUidTotal(String uid);
}
