package com.bob.config;

public class AlipayConfig {

    private String alipay_url;
    private String app_id;
    private String private_key;
    private String alipay_public_key;
    private String alipay_return_url;
    private String alipay_notify_url;
    private String sign_type;
    private String format;
    private String charset;
    private String pay_p2p_return_url;

    public String getAlipay_url() {
        return alipay_url;
    }

    public void setAlipay_url(String alipay_url) {
        this.alipay_url = alipay_url;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getPrivate_key() {
        return private_key;
    }

    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getAlipay_return_url() {
        return alipay_return_url;
    }

    public void setAlipay_return_url(String alipay_return_url) {
        this.alipay_return_url = alipay_return_url;
    }

    public String getAlipay_notify_url() {
        return alipay_notify_url;
    }

    public void setAlipay_notify_url(String alipay_notify_url) {
        this.alipay_notify_url = alipay_notify_url;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getPay_p2p_return_url() {
        return pay_p2p_return_url;
    }

    public void setPay_p2p_return_url(String pay_p2p_return_url) {
        this.pay_p2p_return_url = pay_p2p_return_url;
    }
}
