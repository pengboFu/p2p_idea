package com.bob.pay;

import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class wxpayController {



    @RequestMapping(value = "api/wxpay")
    public @ResponseBody Object wxpay(HttpServletRequest request){

        //没有商户信息，暂时不做，微信支付没有沙箱环境


        return null;
    }

}
