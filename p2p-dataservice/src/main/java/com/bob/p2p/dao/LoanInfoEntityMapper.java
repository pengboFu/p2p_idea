package com.bob.p2p.dao;

import com.bob.p2p.model.LoanInfoEntity;

public interface LoanInfoEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    int insert(LoanInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    int insertSelective(LoanInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    LoanInfoEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    int updateByPrimaryKeySelective(LoanInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(LoanInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    int updateByPrimaryKey(LoanInfoEntity record);
}