package com.bob.p2p.model;

import java.io.Serializable;
import java.util.Date;

public class LoanInfoEntity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_id
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_name
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_rate
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Double rate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_cycle
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer cycle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_release_time
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Date releaseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_type
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer productType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_no
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private String productNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_money
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Double productMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_left_product_money
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Double leftProductMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_bid_min_limit
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Double bidMinLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_bid_max_limit
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Double bidMaxLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_status
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer productStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_full_time
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Date productFullTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_version
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_loan_info.bli_product_desc
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private String productDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_id
     *
     * @return the value of b_loan_info.bli_id
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_id
     *
     * @param id the value for b_loan_info.bli_id
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_name
     *
     * @return the value of b_loan_info.bli_product_name
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_name
     *
     * @param productName the value for b_loan_info.bli_product_name
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_rate
     *
     * @return the value of b_loan_info.bli_rate
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Double getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_rate
     *
     * @param rate the value for b_loan_info.bli_rate
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_cycle
     *
     * @return the value of b_loan_info.bli_cycle
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getCycle() {
        return cycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_cycle
     *
     * @param cycle the value for b_loan_info.bli_cycle
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_release_time
     *
     * @return the value of b_loan_info.bli_release_time
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_release_time
     *
     * @param releaseTime the value for b_loan_info.bli_release_time
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_type
     *
     * @return the value of b_loan_info.bli_product_type
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_type
     *
     * @param productType the value for b_loan_info.bli_product_type
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_no
     *
     * @return the value of b_loan_info.bli_product_no
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public String getProductNo() {
        return productNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_no
     *
     * @param productNo the value for b_loan_info.bli_product_no
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_money
     *
     * @return the value of b_loan_info.bli_product_money
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Double getProductMoney() {
        return productMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_money
     *
     * @param productMoney the value for b_loan_info.bli_product_money
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductMoney(Double productMoney) {
        this.productMoney = productMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_left_product_money
     *
     * @return the value of b_loan_info.bli_left_product_money
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Double getLeftProductMoney() {
        return leftProductMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_left_product_money
     *
     * @param leftProductMoney the value for b_loan_info.bli_left_product_money
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setLeftProductMoney(Double leftProductMoney) {
        this.leftProductMoney = leftProductMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_bid_min_limit
     *
     * @return the value of b_loan_info.bli_bid_min_limit
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Double getBidMinLimit() {
        return bidMinLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_bid_min_limit
     *
     * @param bidMinLimit the value for b_loan_info.bli_bid_min_limit
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setBidMinLimit(Double bidMinLimit) {
        this.bidMinLimit = bidMinLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_bid_max_limit
     *
     * @return the value of b_loan_info.bli_bid_max_limit
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Double getBidMaxLimit() {
        return bidMaxLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_bid_max_limit
     *
     * @param bidMaxLimit the value for b_loan_info.bli_bid_max_limit
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setBidMaxLimit(Double bidMaxLimit) {
        this.bidMaxLimit = bidMaxLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_status
     *
     * @return the value of b_loan_info.bli_product_status
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_status
     *
     * @param productStatus the value for b_loan_info.bli_product_status
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_full_time
     *
     * @return the value of b_loan_info.bli_product_full_time
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Date getProductFullTime() {
        return productFullTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_full_time
     *
     * @param productFullTime the value for b_loan_info.bli_product_full_time
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductFullTime(Date productFullTime) {
        this.productFullTime = productFullTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_version
     *
     * @return the value of b_loan_info.bli_version
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_version
     *
     * @param version the value for b_loan_info.bli_version
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_loan_info.bli_product_desc
     *
     * @return the value of b_loan_info.bli_product_desc
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_loan_info.bli_product_desc
     *
     * @param productDesc the value for b_loan_info.bli_product_desc
     *
     * @mbggenerated Mon May 31 10:44:41 CST 2021
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }
}