package com.bob.p2p.dao.loan;

import com.bob.p2p.model.LoanInfoEntity;

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
    /**
      *
      * @Description:  更新投资金额信息
      * @Author: bob
      * @Date: 2021/5/30 23:15
      * @version v1.0
      *
      */
    int updataleftInfoMoneyByLoanId(Map<String, Object> paramMap);
    /**
      * 根据产品状态查询产品列表
      * @Description: TODO(一句话描述该类的功能)
      * @Author: bob
      * @Date: 2021/5/31 13:41
      * @version v1.0
      *
      */
    List<LoanInfoEntity> selectLoanInfoByProductStatus(int productStatus);
}
