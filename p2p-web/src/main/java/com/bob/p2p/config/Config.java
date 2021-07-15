package com.bob.p2p.config;

public class Config {
    /**
      *
      * @Description: 实名认证Kay
      * @Author: bob
      * @Date: 2021/5/28 13:09
      * @version v1.0
      *
      */
    private String realNameAppKey;
    /**
      *
      * @Description: 实名认证地址
      * @Author: bob
      * @Date: 2021/5/28 13:09
      * @version v1.0
      *
      */
    private String realNameUrl;

    /**
      * 支付宝支付地址
      * @Author: bob
      * @Date: 2021/6/6 20:10
      * @version v1.0
      *
      */
    private String alipayURL;

    /**
      * 支付宝订单查询地址
      * @Author: bob
      * @Date: 2021/6/6 20:14
      * @version v1.0
      *
      */
    private String alipayQueryURL;

    public String getAlipayQueryURL() {
        return alipayQueryURL;
    }

    public void setAlipayQueryURL(String alipayQueryURL) {
        this.alipayQueryURL = alipayQueryURL;
    }

    public String getAlipayURL() {
        return alipayURL;
    }

    public void setAlipayURL(String alipayURL) {
        this.alipayURL = alipayURL;
    }

    public String getRealNameAppKey() {
        return realNameAppKey;
    }

    public void setRealNameAppKey(String realNameAppKey) {
        this.realNameAppKey = realNameAppKey;
    }

    public String getRealNameUrl() {
        return realNameUrl;
    }

    public void setRealNameUrl(String realNameUrl) {
        realNameUrl = realNameUrl;
    }
}
