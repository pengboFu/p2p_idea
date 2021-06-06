package com.bob.pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.bob.config.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
  * 支付宝支付
  * @Description:
  * @Author: bob
  * @Date: 2021/6/4 21:43
  * @version v1.0
  *
  */
@Controller
public class AliPayController {

    @Autowired
    private AlipayConfig alipayConfig;

    /**
      * 调用支付接口
      * @Author: bob
      * @Date: 2021/6/5 12:49
      * @version v1.0
      *
      */
    @RequestMapping("api/aliPay")
    public String AliPayAPI(HttpServletRequest request,Model model,HttpServletResponse response,
                            @RequestParam(value = "outTradeNo",required = true) String out_trade_no,// 商户订单号，商户网站订单系统中唯一订单号，必填
                            @RequestParam(value = "subject",required = true) String subject,// 订单名称，必填
                            @RequestParam(value = "body",required = false) String body,//商品描述，可空
                            @RequestParam(value = "totalAmount",required = true) String total_amount// 付款金额，必填
    ) throws AlipayApiException, UnsupportedEncodingException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getAlipay_url(),
                alipayConfig.getApp_id(),
                alipayConfig.getPrivate_key(),
                alipayConfig.getFormat(),
                alipayConfig.getCharset(),
                alipayConfig.getAlipay_public_key(),
                alipayConfig.getSign_type());

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //同步返回地址
        alipayRequest.setReturnUrl(alipayConfig.getAlipay_return_url());
        //异步返回地址
        alipayRequest.setNotifyUrl(alipayConfig.getAlipay_notify_url());


        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //输出
        model.addAttribute("result",result);

        return "toAlipay";
    }
    /**
      * 同步返回
      * @Author: bob
      * @Date: 2021/6/5 17:09
      * @version v1.0
      *
      */
    @RequestMapping(value = "api/alipayBack")
    public String alipayBack(HttpServletRequest request,Model model
                             ) throws AlipayApiException, UnsupportedEncodingException {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params,
                alipayConfig.getAlipay_public_key(),
                alipayConfig.getCharset(),
                alipayConfig.getSign_type()); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");


            model.addAttribute("signVerified","SUCCESS");
            model.addAttribute("params",params);
            model.addAttribute("alipay_return_url",alipayConfig.getPay_p2p_return_url());
        }else {
            model.addAttribute("signVerified","FAIL");
        }

        return "toP2P";
    }
    /**
      * 查询订单状态
      * @Author: bob
      * @Date: 2021/6/6 10:30
      * @version v1.0
      *
      */
    @RequestMapping(value = "api/alipayQuery")
    public @ResponseBody Object alipayQuery(HttpServletRequest request,
                                            @RequestParam(value = "out_trade_no",required = true) String out_trade_no//商户网站订单系统唯一订单号
                                            ) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getAlipay_url(),
                alipayConfig.getApp_id(),
                alipayConfig.getPrivate_key(),
                alipayConfig.getFormat(),
                alipayConfig.getCharset(),
                alipayConfig.getAlipay_public_key(),
                alipayConfig.getSign_type());

        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        //请二选一设置

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"}");

        //请求
        String result = alipayClient.execute(alipayRequest).getBody();

     return result;
    }
}
