package com.bob.p2p.model.VO;

import java.io.Serializable;

public class ResultObject implements Serializable {
    /**
      *
      * @Description: 错误码
      * @Author: bob
      * @Date: 2021/5/28 9:37
      * @version v1.0
      *
      */
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
