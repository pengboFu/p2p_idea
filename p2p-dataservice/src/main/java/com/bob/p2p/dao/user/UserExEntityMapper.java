package com.bob.p2p.dao.user;

import com.bob.p2p.model.user.UserExEntity;
import org.apache.ibatis.annotations.Param;

public interface UserExEntityMapper {
    /**
     * 查询平台注册总人数
     * @return
     */
    Integer selectUserTotal();
    /**
      *
      * @Description: 根据手机号查询用户
      * @Author: bob
      * @Date: 2021/5/27 21:48
      * @version v1.0
      *
      */
    UserExEntity selectUserByPhone(String phone);
    /**
      *
      * @Description:登录操做查询
      * @Author: bob
      * @Date: 2021/5/28 18:27
      * @version v1.0
      *
      */
    UserExEntity selectUserByPhoneAndPsdForLogin(@Param("phone") String phone,@Param("loginPassword") String loginPassword);
}
