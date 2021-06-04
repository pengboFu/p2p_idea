package com.bob.p2p.service.loan;


import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.LoanInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 产品信息服务
 */
public interface LoanInfoService {

    /**
     * 获取历史年化收益率
     * @return
     */
    Double queryHistoryAverageRate();
    /**
      *
      * @Description: 查询产品
      * @Author: bob
      * @Date: 2021/5/26 13:29
      * @version v1.0
      * @paramType: 0新手宝 1优选 2 散标产品
      */
    List<LoanInfoEntity> queryLoanInfoListByProducetType(Map<String, Object> paramMap);

    /**
      *
      * @Description:
      * @Author: bob
      * @Date: 2021/5/27 12:53
      * @version v1.0
      *
      */
    PagenationVO<LoanInfoEntity> queryLoanInfoVoList(Map<String, Object> paramMap);
    /**
      *
      * @Description:根据产品id查询产品详情
      * @Author: bob
      * @Date: 2021/5/27 17:27
      * @version v1.0
      *
      */

    LoanInfoEntity queryLoanInfoById(Integer id);
}
