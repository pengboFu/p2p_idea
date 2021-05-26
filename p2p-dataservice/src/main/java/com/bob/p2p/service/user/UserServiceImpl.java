package com.bob.p2p.service.user;

import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Integer queryUserTotal() {
        Integer userTotal = (Integer) redisTemplate.opsForValue().get(Constants.USER_TOTAL);

        if (userTotal == null) {
            userTotal = userMapper.selectUserTotal();

            redisTemplate.opsForValue().set(Constants.USER_TOTAL,userTotal,15, TimeUnit.MINUTES);
        }

        return userTotal;
    }


}
