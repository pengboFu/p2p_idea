package com.bob.p2p.model.user;

import java.io.Serializable;
import java.util.Date;

public class UserEntity  implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.id
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.phone
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.loginPassword
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private String loginpassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.name
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.idCard
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private String idcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.addTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Date addtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.lastLoginTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private Date lastlogintime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.headerImage
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    private String headerimage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.id
     *
     * @return the value of u_user.id
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.id
     *
     * @param id the value for u_user.id
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.phone
     *
     * @return the value of u_user.phone
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.phone
     *
     * @param phone the value for u_user.phone
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.loginPassword
     *
     * @return the value of u_user.loginPassword
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public String getLoginpassword() {
        return loginpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.loginPassword
     *
     * @param loginpassword the value for u_user.loginPassword
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.name
     *
     * @return the value of u_user.name
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.name
     *
     * @param name the value for u_user.name
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.idCard
     *
     * @return the value of u_user.idCard
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.idCard
     *
     * @param idcard the value for u_user.idCard
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.addTime
     *
     * @return the value of u_user.addTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.addTime
     *
     * @param addtime the value for u_user.addTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.lastLoginTime
     *
     * @return the value of u_user.lastLoginTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.lastLoginTime
     *
     * @param lastlogintime the value for u_user.lastLoginTime
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.headerImage
     *
     * @return the value of u_user.headerImage
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public String getHeaderimage() {
        return headerimage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.headerImage
     *
     * @param headerimage the value for u_user.headerImage
     *
     * @mbggenerated Thu May 27 12:24:17 CST 2021
     */
    public void setHeaderimage(String headerimage) {
        this.headerimage = headerimage == null ? null : headerimage.trim();
    }
}