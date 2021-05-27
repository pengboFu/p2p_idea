package com.bob.p2p.service.user;

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
}
