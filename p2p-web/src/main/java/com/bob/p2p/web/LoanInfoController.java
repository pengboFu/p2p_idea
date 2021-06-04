package com.bob.p2p.web;

import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.BidInfoExEntity;
import com.bob.p2p.model.LoanInfoEntity;
import com.bob.p2p.model.user.FinanceAccountExEntity;
import com.bob.p2p.model.user.UserExEntity;
import com.bob.p2p.service.loan.BidInfoService;
import com.bob.p2p.service.loan.LoanInfoService;
import com.bob.p2p.service.user.FinanceAccountService;
import com.bob.p2p.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private BidInfoService bidInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private FinanceAccountService financeAccountService;

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
        PagenationVO<LoanInfoEntity> pagenationVO =  loanInfoService.queryLoanInfoVoList(paramMap);

        int totalPage = pagenationVO.getToltal().intValue() / pageSize;

        int mod = totalPage % pageSize;

        if (mod >= 0 ) {
            totalPage = totalPage + 1;
        }
        //TODO
        //投资排行榜

        model.addAttribute("totalRows",pagenationVO.getToltal());
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("loanInfoList",pagenationVO.getDateList());
        model.addAttribute("currentPage",currentPage);

        return "loan";
    }

    @RequestMapping("/loan/loanInfo")
    private String loanInfo(HttpServletRequest request,Model model,
                            @RequestParam(value = "id",required = true) Integer id){

        //根据产品id 获取产品详情
        LoanInfoEntity loanInfoEntity = loanInfoService.queryLoanInfoById(id);

        //获取该产品的用户投资记录
        List<BidInfoExEntity> bidInfoExEntityList = bidInfoService.queryBidInfoListByLoanId(id);


        //获取当前用户的账户可查询余额
        UserExEntity userExEntity = (UserExEntity) request.getSession().getAttribute(Constants.USER_SESSION);
        if (null != userExEntity) {
            //获取用户账户可用余额
            FinanceAccountExEntity financeAccountExEntity = financeAccountService.queryFinanceAccountById(userExEntity.getId());
            model.addAttribute("financeAccount",financeAccountExEntity);
        }

        model.addAttribute("loanInfo",loanInfoEntity);
        model.addAttribute("bidInfoList",bidInfoExEntityList);
        return  "loanInfo";
    }
    /**
      *
      * @Description: 投资页面初始化加载数据
      * @Author: bob
      * @Date: 2021/5/29 15:04
      * @version v1.0
      *
      */
    @RequestMapping(value = "loan/loanStart")
    public @ResponseBody Object loanStart(
            HttpServletRequest httpServletRequest
    ){
        Map<String,Object> resoutMap = new HashMap<>();

        //获取历史年化收益率
        Double historyAverageRate = loanInfoService.queryHistoryAverageRate();

        //获取平台注册总数
        Integer userTotal = userService.queryUserTotal();

        //获A取平台累计投资金额
        Double allBidMoney = bidInfoService.queryAllBidMoney();

        resoutMap.put(Constants.USER_TOTAL,userTotal);
        resoutMap.put(Constants.HISTOR_AVERAGE_RETE,historyAverageRate);
        resoutMap.put(Constants.ALL_BID_MONEY,allBidMoney);
        return resoutMap;
    }

}
