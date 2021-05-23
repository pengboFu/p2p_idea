package com.bob.p2p.service.loan;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.mapper.LoanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: p2p_idea
 * @BelongsPackage: com.bob.p2p.service.loan
 * @Author: Bob
 * @CreateTime: 2021-05-23 10:16
 * @Description:
 */
@Service("loanInfoServiceImpl")
public class LoanInfoServiceImpl implements LoanInfoService{

    @Autowired
    private LoanInfoMapper loanInfoMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Double queryHistoryAverageRate() {
        //判断redis 是否存在历史年化收益率
        Double historyAverageRate = (Double) redisTemplate.opsForValue().get(Constants.HISTOR_AVERAGE_RETE);

        //存在则去除 不存在 则去 获取历史年化收益率
        if (historyAverageRate == null) {
            historyAverageRate =loanInfoMapper.selectHistoryAverageRate();
            redisTemplate.opsForValue().set(Constants.HISTOR_AVERAGE_RETE,historyAverageRate,15, TimeUnit.MINUTES);
        }

        return historyAverageRate;
    }
}
