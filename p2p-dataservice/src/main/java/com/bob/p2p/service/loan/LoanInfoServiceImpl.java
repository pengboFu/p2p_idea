package com.bob.p2p.service.loan;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.dao.loan.LoanInfoExEntityMapper;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.LoanInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
    private LoanInfoExEntityMapper loanInfoExEntityMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Double queryHistoryAverageRate() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //判断redis 是否存在历史年化收益率
        Double historyAverageRate = (Double) redisTemplate.opsForValue().get(Constants.HISTOR_AVERAGE_RETE);

        //存在则去除 不存在 则去 获取历史年化收益率
        if (historyAverageRate == null) {

            historyAverageRate = loanInfoExEntityMapper.selectHistoryAverageRate();

            redisTemplate.opsForValue().set(Constants.HISTOR_AVERAGE_RETE,historyAverageRate,15, TimeUnit.MINUTES);
        }

        return historyAverageRate;
    }

    @Override
    public List<LoanInfoEntity> queryLoanInfoListByProducetType(Map<String, Object> paramMap) {
        List<LoanInfoEntity> loanInfos = loanInfoExEntityMapper.selectLoanInfoByProductType(paramMap);
        return loanInfos;
    }

    @Override
    public PagenationVO<LoanInfoEntity> queryLoanInfoVoList(Map<String, Object> paramMap) {
        PagenationVO<LoanInfoEntity> objectPagenationVO = new PagenationVO<>();
        Long toltal = loanInfoExEntityMapper.selectLoanInfoToltal(paramMap);
        objectPagenationVO.setToltal(toltal);
        List<LoanInfoEntity> loanInfos = loanInfoExEntityMapper.selectLoanInfoByProductType(paramMap);
        objectPagenationVO.setDateList(loanInfos);
        return objectPagenationVO;
    }
}
