package com.bob.p2p.service.loan;


import com.bob.p2p.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service(value = "onlyNumberServiceImpl")
public class OnlyNumberServiceImpl implements OnlyNumberService{

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Long getOnlyNumber() {
        return redisTemplate.opsForValue().increment(Constants.ONLY_NUMBER,1);
    }
}
