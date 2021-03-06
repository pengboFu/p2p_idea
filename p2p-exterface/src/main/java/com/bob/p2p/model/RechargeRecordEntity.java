package com.bob.p2p.model;

import java.io.Serializable;
import java.util.Date;

public class RechargeRecordEntity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_id
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_uid
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_rechargeNo
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private String rechargeno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_rechargeStatus
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private String rechargestatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_rechargeMoney
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Double rechargemoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_rechargeTime
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Date rechargetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_recharge_record.brr_rechargeDesc
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private String rechargedesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_recharge_record
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_id
     *
     * @return the value of b_recharge_record.brr_id
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_id
     *
     * @param id the value for b_recharge_record.brr_id
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_uid
     *
     * @return the value of b_recharge_record.brr_uid
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_uid
     *
     * @param uid the value for b_recharge_record.brr_uid
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_rechargeNo
     *
     * @return the value of b_recharge_record.brr_rechargeNo
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public String getRechargeno() {
        return rechargeno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_rechargeNo
     *
     * @param rechargeno the value for b_recharge_record.brr_rechargeNo
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setRechargeno(String rechargeno) {
        this.rechargeno = rechargeno == null ? null : rechargeno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_rechargeStatus
     *
     * @return the value of b_recharge_record.brr_rechargeStatus
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public String getRechargestatus() {
        return rechargestatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_rechargeStatus
     *
     * @param rechargestatus the value for b_recharge_record.brr_rechargeStatus
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setRechargestatus(String rechargestatus) {
        this.rechargestatus = rechargestatus == null ? null : rechargestatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_rechargeMoney
     *
     * @return the value of b_recharge_record.brr_rechargeMoney
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Double getRechargemoney() {
        return rechargemoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_rechargeMoney
     *
     * @param rechargemoney the value for b_recharge_record.brr_rechargeMoney
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setRechargemoney(Double rechargemoney) {
        this.rechargemoney = rechargemoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_rechargeTime
     *
     * @return the value of b_recharge_record.brr_rechargeTime
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Date getRechargetime() {
        return rechargetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_rechargeTime
     *
     * @param rechargetime the value for b_recharge_record.brr_rechargeTime
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setRechargetime(Date rechargetime) {
        this.rechargetime = rechargetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_recharge_record.brr_rechargeDesc
     *
     * @return the value of b_recharge_record.brr_rechargeDesc
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public String getRechargedesc() {
        return rechargedesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_recharge_record.brr_rechargeDesc
     *
     * @param rechargedesc the value for b_recharge_record.brr_rechargeDesc
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setRechargedesc(String rechargedesc) {
        this.rechargedesc = rechargedesc == null ? null : rechargedesc.trim();
    }
}