package com.bob.p2p.service.loan;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.dao.loan.BidInfoExEntityMapper;
import com.bob.p2p.model.loan.BidInfoExEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("bidInfoSerivceImpl")
public class BidInfoSerivceImpl implements BidInfoService{

    @Autowired
    private BidInfoExEntityMapper bidInfoExEntityMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Double queryAllBidMoney() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        BoundValueOperations<Object,Object> boundValueOps = redisTemplate.boundValueOps(Constants.ALL_BID_MONEY);

        Double allBidMoney = (Double) boundValueOps.get();

        if (allBidMoney == null) {
            allBidMoney = bidInfoExEntityMapper.selectALlBidMoney();

            boundValueOps.set(allBidMoney,15, TimeUnit.MINUTES);
        }

        return allBidMoney;
    }

    @Override
    public List<BidInfoExEntity> queryBidInfoListByLoanId(Integer id) {

        return bidInfoExEntityMapper.selectBidInfoListByLoanId( id);
    }
}
