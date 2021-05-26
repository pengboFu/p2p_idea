package com.bob.p2p.mapper;

import com.bob.p2p.model.loan.LoanInfo;

import java.util.List;
import java.util.Map;


public interface LoanInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int insert(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int insertSelective(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    LoanInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int updateByPrimaryKeySelective(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int updateByPrimaryKey(LoanInfo record);

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
    List<LoanInfo> selectLoanInfoByProductType(Map<String, Object> paramMap);
}