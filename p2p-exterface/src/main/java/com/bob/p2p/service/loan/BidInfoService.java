package com.bob.p2p.service.loan;

import com.bob.p2p.model.VO.BidUserTop;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.VO.ResultObject;
import com.bob.p2p.model.loan.BidInfoExEntity;
import com.bob.p2p.model.loan.LoanInfoExEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
  *
  * @Description: 投资服务
  * @Author: bob
  * @Date: 2021/5/26 10:51
  * @version v1.0
  *
  */
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

    /**
      *
      * @Description: 用户投资
      * @Author: bob
      * @Date: 2021/5/30 16:52
      * @version v1.0
      *
      */
    ResultObject invert(Map<String, Object> paramMap);
    /**
      * 获取用户投资排行榜
      * @Description:
      * @Author: \
      * @Date: 2021/6/4 13:37
      * @version v1.0
      *
      */
    List<BidUserTop> queryBidUserTop();
    /**
      *根据用户id查询投资记录  带分页
      * @Description:
      * @Author: bob
      * @Date: 2021/6/4 22:40
      * @version v1.0
      *
      */
    List<BidInfoExEntity> queryBidInfoListTopByUid(Map<String, Object> paramMap);
    /**
      *
      * @Author: bob
      * @Date: 2021/6/5 0:38
      * @version v1.0
      *
      */
    PagenationVO<BidInfoExEntity> queryBidInfoListByUid(Map<String, Object> paramMap);
}
