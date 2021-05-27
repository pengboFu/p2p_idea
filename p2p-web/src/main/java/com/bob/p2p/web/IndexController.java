package com.bob.p2p.web;

import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.model.loan.LoanInfoEntity;
import com.bob.p2p.service.loan.BidInfoService;
import com.bob.p2p.service.loan.LoanInfoService;
import com.bob.p2p.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 首页处理器
 */
@Controller
public class IndexController {

    @Autowired
    private LoanInfoService loanInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private BidInfoService bidInfoService;

    /**
     * 首页查询
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){
        //获取历史年化收益率
        Double historyAverageRate = loanInfoService.queryHistoryAverageRate();
        model.addAttribute(Constants.HISTOR_AVERAGE_RETE,historyAverageRate);

        //获取平台注册总数
        Integer userTotal = userService.queryUserTotal();
        model.addAttribute(Constants.USER_TOTAL,userTotal);

        //获A取平台累计投资金额
        Double allBidMoney = bidInfoService.queryAllBidMoney();
        model.addAttribute(Constants.ALL_BID_MONEY,allBidMoney);

        //获取新手宝产品 0新手宝 1优选 2 散标产品
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("currentPage",0);
        paramMap.put("pageSize",1);
        paramMap.put("productType",Constants.PRODUCET_TYPE_X);
        List<LoanInfoEntity> xLoanInfoList = loanInfoService.queryLoanInfoListByProducetType(paramMap);

        //获取优选产品
        paramMap.put("productType",Constants.PRODUCET_TYPE_U);
        paramMap.put("pageSize",4);
        List<LoanInfoEntity> uLoanInfoList = loanInfoService.queryLoanInfoListByProducetType(paramMap);

        //获取散标产品
        paramMap.put("productType",Constants.PRODUCET_TYPE_S);
        paramMap.put("pageSize",8);
        List<LoanInfoEntity> sLoanInfoList = loanInfoService.queryLoanInfoListByProducetType(paramMap);

        model.addAttribute("xLoanInfoList",xLoanInfoList);
        model.addAttribute("uLoanInfoList",uLoanInfoList);
        model.addAttribute("sLoanInfoList",sLoanInfoList);
        return "index";
    }


}
