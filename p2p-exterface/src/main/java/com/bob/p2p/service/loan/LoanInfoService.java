package com.bob.p2p.service.loan;


import com.bob.p2p.model.loan.LoanInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 产品信息服务
 */

@Service
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
    List<LoanInfo> queryLoanInfoListByProducetType(Map<String, Object> paramMap);
}
