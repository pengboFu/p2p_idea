package com.bob.p2p.model.VO;

import java.io.Serializable;

public class BidUserTop implements Serializable {

    /**
      * 手机号
      * @Description:
      * @Author: \
      * @Date: 2021/6/4 13:35
      * @version v1.0
      *
      */
    private String phone;

    /**
      * 分数：累计投资金额
      * @Description:
      * @Author: bob
      * @Date: 2021/6/4 13:36
      * @version v1.0
      *
      */
    private Double score;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
