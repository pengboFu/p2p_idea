package com.bob.p2p.mapper;

import com.bob.p2p.model.DealRecord;

public interface DealRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_deal_record
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_deal_record
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int insert(DealRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_deal_record
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int insertSelective(DealRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_deal_record
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    DealRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_deal_record
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int updateByPrimaryKeySelective(DealRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_deal_record
     *
     * @mbggenerated Sat May 22 18:30:38 CST 2021
     */
    int updateByPrimaryKey(DealRecord record);
}