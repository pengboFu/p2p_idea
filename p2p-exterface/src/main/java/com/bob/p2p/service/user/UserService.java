package com.bob.p2p.service.user;

import com.bob.p2p.model.UserEntity;
import com.bob.p2p.model.VO.ResultObject;
import com.bob.p2p.model.user.UserExEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 查询平台注册总人数
     * @return
     */
    Integer queryUserTotal();

    /**
      *
      * @Description: 根据phone查询用户
      * @Author: bob
      * @Date: 2021/5/27 21:45
      * @version v1.0
      *@param phone
     * @return
     */
    UserExEntity queryIsUserPhone(String phone);
    /**
      *
      * @Description: 注册账户
      * @Author: bob
      * @Date: 2021/5/28 9:39
      * @version v1.0
      *
      */
    ResultObject register(String phone, String loginpassword);
    /**
      *
      * @Description: 更新用户信息
      * @Author: bob
      * @Date: 2021/5/28 13:55
      * @version v1.0
      *
      */
    int modifyUserById(UserEntity userParam);
}
