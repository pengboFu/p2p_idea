package com.bob.p2p.web;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.model.UserEntity;
import com.bob.p2p.model.user.UserExEntity;
import com.bob.p2p.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

}