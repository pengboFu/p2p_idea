package com.bob.p2p.service.user;

import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.dao.user.UserExEntityMapper;
import com.bob.p2p.model.user.UserExEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserExEntityMapper userExEntityMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Integer queryUserTotal() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        BoundValueOperations<Object, Object> boundValueOps = redisTemplate.boundValueOps(Constants.USER_TOTAL);

        Integer userTotal = (Integer) boundValueOps.get();

        if (userTotal == null) {

            userTotal = userExEntityMapper.selectUserTotal();

            redisTemplate.opsForValue().set(Constants.USER_TOTAL,userTotal,15, TimeUnit.MINUTES);
        }

        return userTotal;
    }

    @Override
    public UserExEntity queryIsUserPhone(String phone) {
        return  userExEntityMapper.selectUserByPhone(phone);
    }


}
