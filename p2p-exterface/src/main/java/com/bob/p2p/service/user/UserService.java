package com.bob.p2p.service.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 查询平台注册总人数
     * @return
     */
    Integer queryUserTotal();


}
