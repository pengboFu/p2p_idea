package com.bob.p2p.web;

import com.alibaba.fastjson.JSONObject;
import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.common.core.utils.DateUtils;
import com.bob.p2p.common.core.utils.HttpClientUtils;
import com.bob.p2p.config.Config;
import com.bob.p2p.model.RechargeRecordEntity;
import com.bob.p2p.model.UserEntity;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.BidInfoExEntity;
import com.bob.p2p.model.loan.RechargeRecordExEntity;
import com.bob.p2p.service.loan.OnlyNumberService;
import com.bob.p2p.service.loan.RechargeRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
  * 充值接口
  * @Description:
  * @Author: bob
  * @Date: 2021/6/4 20:42
  * @version v1.0
  *
  */
@Controller
public class RechargeRecordController {

    @Autowired
    private OnlyNumberService onlyNumberService;

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @Autowired
    private Config config;

    /**
      * 支付宝充值
      * @Description:
      * @Author: bob
      * @Date: 2021/6/4 20:43
      * @version v1.0
      *
      */
    @RequestMapping(value = "/loan/toAlipayRecharge")
    public String toAlipayRecharge(HttpServletRequest request, Model model,
                                   @RequestParam(value = "rachargeMoney",required = true) Double alipayRachargeMoney
                                   ){
        //获取用户信息，by session
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute(Constants.USER_SESSION);

        //生成一个全局唯一的充值订单号  = 时间戳 + redis 全局唯一数字
        String rechargeNo = DateUtils.getTimeStamp() + onlyNumberService.getOnlyNumber();


        //生成充值記錄 （充值中）
        RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
        rechargeRecordEntity.setUid(userEntity.getId());
        rechargeRecordEntity.setRechargemoney(alipayRachargeMoney);
        rechargeRecordEntity.setRechargetime(new Date());
        rechargeRecordEntity.setRechargestatus("0");
        rechargeRecordEntity.setRechargeno(rechargeNo);
        rechargeRecordEntity.setRechargedesc("支付宝充值");
        int addRechargeRecord =  rechargeRecordService.addRechargeRecord(rechargeRecordEntity);

        if (0 < addRechargeRecord) {
            //向pay工程传递参数
            model.addAttribute("alipay_pay_url",config.getAlipayURL());
            model.addAttribute("rechargeMoney",alipayRachargeMoney);
            model.addAttribute("rechargeNo",rechargeNo);
            model.addAttribute("subject","支付宝充值");
            model.addAttribute("userId",userEntity.getId());
        }else {
            model.addAttribute("trade_msg","充值人数过多，请稍后重试...");
            return "toRechargeBack";
        }
        return "toAlipay";
    }


    /**
     * 微信充值
     * @Description:
     * @Author: bob
     * @Date: 2021/6/4 20:43
     * @version v1.0
     *
     */
    @RequestMapping(value = "/loan/toWxpayRecharge")
    public String toWxpayRecharge(HttpServletRequest request, Model model,
                                   @RequestParam(value = "rachargeMoney",required = true) Double wxpayRachargeMoney
    ){
        //获取用户信息，by session
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute(Constants.USER_SESSION);

        //生成一个全局唯一的充值订单号  = 时间戳 + redis 全局唯一数字
        String rechargeNo = DateUtils.getTimeStamp() + onlyNumberService.getOnlyNumber();


        //生成充值記錄 （充值中）
        RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
        rechargeRecordEntity.setUid(userEntity.getId());
        rechargeRecordEntity.setRechargemoney(wxpayRachargeMoney);
        rechargeRecordEntity.setRechargetime(new Date());
        rechargeRecordEntity.setRechargestatus("0");
        rechargeRecordEntity.setRechargeno(rechargeNo);
        rechargeRecordEntity.setRechargedesc("微信充值");
        int addRechargeRecord =  rechargeRecordService.addRechargeRecord(rechargeRecordEntity);
        if (0 < addRechargeRecord) {
            //向pay工程传递参数

        }else {
            model.addAttribute("trade_msg","充值人数过多，请稍后重试...");
            return "toRechargeBack";
        }

        return null;
    }
    /**
      *支付同步返回信息
      * @Author: bob
      * @Date: 2021/6/5 17:39
      * @version v1.0
      *
      */
    @RequestMapping(value = "/loan/alipayBack")
    public String alipayBack(
            HttpServletRequest request, Model model,
            @RequestParam(value = "signVerified",required = true) String signVerified,
            @RequestParam(value = "total_amount",required = true) Double total_amount,
            @RequestParam(value = "out_trade_no",required = true) String outTradeNo
    ){
        //判断验签结果
        if (StringUtils.containsIgnoreCase("SUCCESS",signVerified)) {
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("out_trade_no",outTradeNo);
            //成功
            //查询该笔订单状态
//            String jsonString =  HttpClientUtils.doPost("http://localhost:9090/pay/api/alipayQuery",paramMap);
            String jsonString =  HttpClientUtils.doPost(config.getAlipayQueryURL(),paramMap);

            JSONObject jsonObject = JSONObject.parseObject(jsonString);

            JSONObject alipayTradeQueryResponse = jsonObject.getJSONObject("alipay_trade_query_response");

            String code = alipayTradeQueryResponse.getString("code");

            if (StringUtils.equals("10000",code)) {
                //执行业务逻辑，
                String tradeStatus = alipayTradeQueryResponse.getString("trade_status");
                //交易状态：
                // WAIT_BUYER_PAY（交易创建，等待买家付款）
                //TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）
                //TRADE_SUCCESS（交易支付成功）
                //TRADE_FINISHED（交易结束，不可退款）
                switch (tradeStatus){
                    //交易失败
                    case "TRADE_CLOSED":
                    //更新充值记录状态为2，充值失败
                        RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
                        rechargeRecordEntity.setRechargeno(outTradeNo);
                        rechargeRecordEntity.setRechargestatus("2");
                        int updateStatus = rechargeRecordService.modifyRechargeRecordByRecordNo(rechargeRecordEntity);
                        if (updateStatus < 0){
                            //失败
                            model.addAttribute("trade_msg","充值人数过多，请稍后充值.......");
                            return "toRechargeBack";
                        }
                        break;
                     //交易成功
                    case "TRADE_SUCCESS":
                        //给用户充值，1。更新账户可用余额，2.更新充值状态为1 ，参数 用户标识， 充值金额，充值订单号
                        UserEntity userEntity = (UserEntity) request.getSession().getAttribute(Constants.USER_SESSION);
                        Map<String,Object> paramMapForRecharge = new HashMap<>();
                        paramMapForRecharge.put("uid",userEntity.getId());
                        paramMapForRecharge.put("rechargeAmount",total_amount);
                        paramMapForRecharge.put("rechargeNo",outTradeNo);
                        int rechargeStatus = rechargeRecordService.recharge(paramMapForRecharge);
                        if (rechargeStatus < 0){
                            //失败
                            model.addAttribute("trade_msg","充值人数过多，请稍后充值.......");
                            return "toRechargeBack";
                        }
                        break;
                    default: break;
                }
            }else {
                //失败
                model.addAttribute("trade_msg","充值人数过多，请稍后充值.......");
                return "toRechargeBack";
            }
        }else {
            //失败
            model.addAttribute("trade_msg","充值人数过多，请稍后充值.......");
            return "toRechargeBack";
        }

        return "redirect:/loan/myCenter";
    }

    /**
     * 查看全部充值记录
     * @Author: bob
     * @Date: 2021/6/5 0:10
     * @version v1.0
     *
     */
    @RequestMapping(value = "/loan/myRecharge")
    public String myRecharge(HttpServletRequest request, Model model,
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

        PagenationVO<RechargeRecordExEntity> loanInfoExEntities = rechargeRecordService.queryRechargeRecordListByUid(paramMap);

        int totalPage = loanInfoExEntities.getToltal().intValue() / pageSize;

        int mod = totalPage % pageSize;

        if (mod >= 0 ) {
            totalPage = totalPage + 1;
        }
        model.addAttribute("totalRows",loanInfoExEntities.getToltal());
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("rechargeRecordList",loanInfoExEntities.getDateList());
        model.addAttribute("currentPage",currentPage);

        return "myRecharge";
    }

}
