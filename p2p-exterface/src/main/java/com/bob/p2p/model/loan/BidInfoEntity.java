package com.bob.p2p.model.loan;

import java.io.Serializable;
import java.util.Date;

public class BidInfoEntity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.id
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.loanId
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Integer loanid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.uid
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bidMoney
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Double bidmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bidTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Date bidtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bidStatus
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Integer bidstatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.id
     *
     * @return the value of b_bid_info.id
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.id
     *
     * @param id the value for b_bid_info.id
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.loanId
     *
     * @return the value of b_bid_info.loanId
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Integer getLoanid() {
        return loanid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.loanId
     *
     * @param loanid the value for b_bid_info.loanId
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.uid
     *
     * @return the value of b_bid_info.uid
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.uid
     *
     * @param uid the value for b_bid_info.uid
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bidMoney
     *
     * @return the value of b_bid_info.bidMoney
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Double getBidmoney() {
        return bidmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bidMoney
     *
     * @param bidmoney the value for b_bid_info.bidMoney
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setBidmoney(Double bidmoney) {
        this.bidmoney = bidmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bidTime
     *
     * @return the value of b_bid_info.bidTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Date getBidtime() {
        return bidtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bidTime
     *
     * @param bidtime the value for b_bid_info.bidTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setBidtime(Date bidtime) {
        this.bidtime = bidtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bidStatus
     *
     * @return the value of b_bid_info.bidStatus
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Integer getBidstatus() {
        return bidstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bidStatus
     *
     * @param bidstatus the value for b_bid_info.bidStatus
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setBidstatus(Integer bidstatus) {
        this.bidstatus = bidstatus;
    }
}