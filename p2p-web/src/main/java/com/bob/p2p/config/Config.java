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
