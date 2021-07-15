package com.bob.p2p.web;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.model.UserEntity;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.VO.ResultObject;
import com.bob.p2p.model.loan.BidInfoExEntity;
import com.bob.p2p.model.loan.LoanInfoExEntity;
import com.bob.p2p.model.user.UserExEntity;
import com.bob.p2p.service.loan.BidInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BIdInfoController {

    @Autowired
    BidInfoService bidInfoService;


    /**
      * 用户投资
      * @Author: bob
      * @Date: 2021/5/30 16:36
      * @version v1.0
      *
      */
    @RequestMapping(value = "/loan/invest")
    public @ResponseBody Object inverst(
            HttpServletRequest request,
            @RequestParam(value = "loanId",required = true) final String loanId,
            @RequestParam(value = "bidMoney",required = true) final Double bidMoney
    ){

        Map<String,Object> retMap = new HashMap<>();
        //获取用户信息
        UserExEntity userExEntity = (UserExEntity) request.getSession().getAttribute(Constants.USER_SESSION);
        //拼接查询参数
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("uid",userExEntity.getId());
        paramMap.put("loanId",loanId);
        paramMap.put("bidMoney",bidMoney);
        paramMap.put("phone",userExEntity.getPhone());
        //更新数据库投资数据
        ResultObject resultObject =  bidInfoService.invert(paramMap);

        if (StringUtils.equals(resultObject.getErrorCode(),Constants.SUCCESS)) {
            retMap.put(Constants.ERROR_MASSAGE,Constants.OK);
        }else {
            retMap.put(Constants.ERROR_MASSAGE,"投资人数过多，请稍后重试");
        }
        return  retMap;
    }

    /**
     * 查看全部投资
     * @Author: bob
     * @Date: 2021/6/5 0:10
     * @version v1.0
     *
     */
    @RequestMapping(value = "/loan/myInvest")
    public String myInvest(HttpServletRequest request, Model model,
                           @RequestParam(value = "currentPage",required = false) Integer currentPage
    ){
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute(Constants.USER_SESSION);
        Map<String,Object> paramMap = new HashMap<>();

        if (null == currentPage || currentPage == 0) {
            currentPage = 1;
        }
        paramMap.put("uid",userEntity.getId());

        int pageSize = 10;

        paramMap.put("currentPage",(currentPage - 1) * pageSize);

        paramMap.put("pageSize",pageSize);

        PagenationVO<BidInfoExEntity> bidInfoExEntityPagenationVO = bidInfoService.queryBidInfoListByUid(paramMap);

        int totalPage = bidInfoExEntityPagenationVO.getToltal().intValue() / pageSize;

        int mod = totalPage % pageSize;

        if (mod >= 0 ) {
            totalPage = totalPage + 1;
        }
        model.addAttribute("totalRows",bidInfoExEntityPagenationVO.getToltal());
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("bidInfoList",bidInfoExEntityPagenationVO.getDateList());
        model.addAttribute("currentPage",currentPage);
        return "myInvest";
    }

}
