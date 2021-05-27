package com.bob.p2p.model;

import java.io.Serializable;
import java.util.Date;

public class BidInfoEntity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bbi_id
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bbi_loanId
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private Integer loanid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bbi_uid
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bbi_bidMoney
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private Double bidmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bbi_bidTime
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private Date bidtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bbi_bidStatus
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private Integer bidstatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_bid_info
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bbi_id
     *
     * @return the value of b_bid_info.bbi_id
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bbi_id
     *
     * @param id the value for b_bid_info.bbi_id
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bbi_loanId
     *
     * @return the value of b_bid_info.bbi_loanId
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public Integer getLoanid() {
        return loanid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bbi_loanId
     *
     * @param loanid the value for b_bid_info.bbi_loanId
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bbi_uid
     *
     * @return the value of b_bid_info.bbi_uid
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bbi_uid
     *
     * @param uid the value for b_bid_info.bbi_uid
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bbi_bidMoney
     *
     * @return the value of b_bid_info.bbi_bidMoney
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public Double getBidmoney() {
        return bidmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bbi_bidMoney
     *
     * @param bidmoney the value for b_bid_info.bbi_bidMoney
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public void setBidmoney(Double bidmoney) {
        this.bidmoney = bidmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bbi_bidTime
     *
     * @return the value of b_bid_info.bbi_bidTime
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public Date getBidtime() {
        return bidtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bbi_bidTime
     *
     * @param bidtime the value for b_bid_info.bbi_bidTime
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public void setBidtime(Date bidtime) {
        this.bidtime = bidtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bbi_bidStatus
     *
     * @return the value of b_bid_info.bbi_bidStatus
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public Integer getBidstatus() {
        return bidstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bbi_bidStatus
     *
     * @param bidstatus the value for b_bid_info.bbi_bidStatus
     *
     * @mbggenerated Thu May 27 18:45:23 CST 2021
     */
    public void setBidstatus(Integer bidstatus) {
        this.bidstatus = bidstatus;
    }
}