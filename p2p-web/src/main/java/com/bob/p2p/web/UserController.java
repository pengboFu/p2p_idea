package com.bob.p2p.web;


import com.alibaba.fastjson.JSONObject;
import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.common.core.utils.HttpClientUtils;
import com.bob.p2p.config.Config;
import com.bob.p2p.model.UserEntity;
import com.bob.p2p.model.VO.ResultObject;
import com.bob.p2p.model.user.UserExEntity;
import com.bob.p2p.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
  *
  * @Description: 用户服务器
  * @Author: bob
  * @Date: 2021/5/27 20:55
  * @version v1.0
  *
  */
@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private Config config;

    /**
      *
      * @Description:查询手机号是否存在
      * @Author: bob
      * @Date: 2021/5/27 20:59
      * @version v1.0
      *
      */

    @PostMapping("loan/checkPhone")
    public @ResponseBody Object checkPhone(HttpServletRequest request,
                                           @RequestParam(value = "phone",required = true) String phone){
        Map<String,Object> map = new HashMap<>();

        //查询手机号是否存在
        UserExEntity userEntity = userService.queryIsUserPhone(phone);

        if (null != userEntity) {
            map.put(Constants.ERROR_MASSAGE,"对不起，此号码已被注册");
            return map;
        }
        map.put(Constants.ERROR_MASSAGE,Constants.OK);

        return map;
    }
    /**
      *
      * @Description:图形验证
      * @Author: bob
      * @Date: 2021/5/27 23:14
      * @version v1.0
      *
      */
    @PostMapping("loan/verifyCaptcha")
    public @ResponseBody Object verifyCaptcha(
            HttpServletRequest request,
            @RequestParam(value = "captcha",required = true) final String captcha
    ){
        Map<String,Object> map = new HashMap<>();

        String attribute = (String) request.getSession().getAttribute(Constants.CAPTCHA);

        if (null != attribute) {
            if (attribute.equalsIgnoreCase(captcha)) {
                map.put(Constants.ERROR_MASSAGE,Constants.OK);
                return map;
            }else {
                map.put(Constants.ERROR_MASSAGE,"请输入正确的验证码");
                return map;
            }
        }
        map.put(Constants.ERROR_MASSAGE,"请输入验证码");
        return map;
    }
    /**
      *
      * @Description: 注册验证
      * @Author: bob
      * @Date: 2021/5/28 9:33
      * @version v1.0
      *
      */
    @PostMapping("loan/register")
    public @ResponseBody Object register(
            HttpServletRequest request,
            @RequestParam(value ="phone",required = true) final String phone,
            @RequestParam(value = "loginPassword",required = true) final  String loginpassword,
            @RequestParam(value = "replayLoginPassword",required = true) final  String replayLoginPassword

    ){
        Map<String,Object>  map = new HashMap<>();

        if (!Pattern.matches("^[0-9a-zA-Z]+$",phone)) {
            map.put(Constants.ERROR_MASSAGE,"请输入正确的手机号码");
            return map;
        }

        if (!StringUtils.equals(loginpassword,replayLoginPassword)) {
            map.put(Constants.ERROR_MASSAGE,"两次输入密码不一致");
            return map;
        }

        ResultObject resultObject = userService.register(phone,loginpassword);

        if (!StringUtils.equals(resultObject.getErrorCode(),Constants.SUCCESS)) {
            map.put(Constants.ERROR_MASSAGE,"对不起，系统繁忙请稍后在试...");
            return map;
        }

        request.getSession().setAttribute(Constants.USER_SESSION,userService.queryIsUserPhone(phone));
        map.put(Constants.ERROR_MASSAGE,Constants.OK);
        return map;
    }

    /**
      *
      * @Description: 实名认证
      * @Author: bob
      * @Date: 2021/5/28 12:46
      * @version v1.0
      *
      */
    @RequestMapping(value = "loan/checkRealName")
    public @ResponseBody Object checkRealName(
            HttpServletRequest request,
            @RequestParam(value = "realName",required = true) final String realName,
            @RequestParam(value = "idCard",required = true) final  String idCard,
            @RequestParam(value = "replayIdCard",required = true) final  String replayIdCard
    ){
        Map<String,Object> map = new HashMap<>();

        if (!Pattern.matches("[\\u4e00-\\u9fa5]{0,}$",realName)) {
            map.put(Constants.ERROR_MASSAGE,"请输入中文名字");
            return map;
        }

        if (!Pattern.matches("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)",idCard)) {
            map.put(Constants.ERROR_MASSAGE,"请输正确的身份证号码");
            return map;
        }

        if (!StringUtils.equals(idCard,replayIdCard)) {
            map.put(Constants.ERROR_MASSAGE,"两次输入身份证号不一致");
            return map;
        }

        Map<String,Object> mapParam = new HashMap<>();

        mapParam.put("cardNo",idCard);

        mapParam.put("realName",realName);

        mapParam.put("appkey",config.getRealNameAppKey());

        String jsonString = HttpClientUtils.doPost(config.getRealNameUrl(), mapParam);

        JSONObject jsonObject = JSONObject.parseObject("{\"code\":\"10000\",\"charge\":false,\"remain\":1305,\"msg\":\"查询成功\",\"result\":{\"error_code\":0,\"reason\":\"Success\",\"result\":{\"realname\":\"龙球球\",\"idcard\":\"3303***********\",\"isok\":true,\"IdCardInfor\":{\"area\":\"浙江省杭州市区清徐县\",\"sex\":\"男\",\"birthday\":\"1965-3-10\"}}}}");
//        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        String code = jsonObject.getString("code");

        if (StringUtils.equals("10000",code)) {

            Boolean isok = jsonObject.getJSONObject("result").getJSONObject("result").getBoolean("isok");

            if (isok) {
                UserEntity userParam = new UserEntity();
                //验证通过，更新用户信息
                UserEntity sessionUser = (UserEntity) request.getSession().getAttribute(Constants.USER_SESSION);
                userParam.setName(realName);
                userParam.setIdcard(idCard);
                userParam.setId(sessionUser.getId());
                int modifyOk = userService.modifyUserById(userParam);
                if (modifyOk > 0) {
                    request.getSession().setAttribute(Constants.USER_SESSION,userService.queryIsUserPhone(sessionUser.getPhone()));
                    map.put(Constants.ERROR_MASSAGE,Constants.OK);
                    return  map;
                }else {
                    map.put(Constants.ERROR_MASSAGE,"系统繁忙，请稍后再试...");
                    return  map;
                }
            }else {
                map.put(Constants.ERROR_MASSAGE,"真实姓名与用户名不匹配");
                return  map;
            }
        }

        map.put(Constants.ERROR_MASSAGE,"通信失败，请稍后重试...");
        return  map;
    }

}
