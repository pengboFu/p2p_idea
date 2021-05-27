package com.bob.p2p.model.VO;

import java.io.Serializable;
import java.util.List;

public class PagenationVO<T> implements Serializable {
    
    /**
      *
      * @Description: 
      * @Author: bob
      * @Date: 2021/5/27 12:58
      * @version v1.0
      *
      */
    private Long toltal;
    /**
      *
      * @Description: TODO(一句话描述该类的功能)
      * @Author: bob
      * @Date: 2021/5/27 12:59
      * @version v1.0
      *
      */
    private List<T> dateList;

    public Long getToltal() {
        return toltal;
    }

    public void setToltal(Long toltal) {
        this.toltal = toltal;
    }

    public List<T> getDateList() {
        return dateList;
    }

    public void setDateList(List<T> dateList) {
        this.dateList = dateList;
    }
}
