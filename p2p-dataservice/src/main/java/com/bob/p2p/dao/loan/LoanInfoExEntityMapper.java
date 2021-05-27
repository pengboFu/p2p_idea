package com.bob.p2p.dao.loan;

import com.bob.p2p.model.loan.LoanInfoEntity;

import java.util.List;
import java.util.Map;

public interface LoanInfoExEntityMapper {


    /**
     * 查询历史年化收益率
     * @return
     */
    Double selectHistoryAverageRate();
    /**
     *
     * @Description: 查询产品按照类型
     * @Author: bob
     * @Date: 2021/5/26 13:31
     * @version v1.0
     *
     */
    List<LoanInfoEntity> selectLoanInfoByProductType(Map<String, Object> paramMap);
    /**
      *
      * @Description: 查询产品总数
      * @Author: bob
      * @Date: 2021/5/27 13:07
      * @version v1.0
      *
      */
    Long selectLoanInfoToltal(Map<String, Object> paramMap);
}
