package com.bob.p2p.web;

import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.LoanInfo;
import com.bob.p2p.service.loan.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
  *
  * @Description: 产品服务器
  * @Author: bob
  * @Date: 2021/5/26 22:55
  * @version v1.0
  *
  */
@Controller
public class LoanInfoController {

    @Autowired
    private LoanInfoService loanInfoService;



    /**
      *
      * @Description: 产品查询服务
      * @Author: bob
      * @Date: 2021/5/26 22:57
      * @version v1.0
      *
      */

    @RequestMapping(value = "/loan/loan")
    public String loan(HttpServletRequest request,Model model,
                       @RequestParam(value = "ptype",required = false) Integer ptype,
                       @RequestParam(value = "currentPage",required = false) Integer currentPage
                       ){
        Map<String,Object> paramMap = new HashMap<>();

        if (null == currentPage || currentPage == 0) {
            currentPage = 1;
        }

        //如果用户请求的类型是null的话
        if (null != ptype) {
            paramMap.put("productType",ptype);
            model.addAttribute("ptype",ptype);
        }
        int pageSize = 9;
        paramMap.put("currentPage",(currentPage - 1) * pageSize);

        paramMap.put("pageSize",pageSize);

        //返回的list  要包含  总条数  和 产品对象
        PagenationVO<LoanInfo> pagenationVO =  loanInfoService.queryLoanInfoVoList(paramMap);

        int totalPage = pagenationVO.getToltal().intValue() / pageSize;

        int mod = totalPage % pageSize;

        if (mod >= 0 ) {
            totalPage = totalPage + 1;
        }


        model.addAttribute("totalRows",pagenationVO.getToltal());
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("loanInfoList",pagenationVO.getDateList());
        model.addAttribute("currentPage",currentPage);

        return "loan";
    }

}
