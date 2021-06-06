package com.bob.p2p.service.loan;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.dao.BidInfoEntityMapper;
import com.bob.p2p.dao.LoanInfoEntityMapper;
import com.bob.p2p.dao.loan.BidInfoExEntityMapper;
import com.bob.p2p.dao.loan.LoanInfoExEntityMapper;
import com.bob.p2p.dao.user.FinanceAccountExEntityMapper;
import com.bob.p2p.model.BidInfoEntity;
import com.bob.p2p.model.LoanInfoEntity;
import com.bob.p2p.model.VO.BidUserTop;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.VO.ResultObject;
import com.bob.p2p.model.loan.BidInfoExEntity;
import com.bob.p2p.model.loan.LoanInfoExEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("bidInfoSerivceImpl")
public class BidInfoSerivceImpl implements BidInfoService{

    @Autowired
    private BidInfoExEntityMapper bidInfoExEntityMapper;

    @Autowired
    private BidInfoEntityMapper bidInfoEntityMapper;

    @Autowired
    private LoanInfoEntityMapper loanInfoEntityMapper;

    @Autowired
    private LoanInfoExEntityMapper loanInfoExEntityMapper;

    @Autowired
    private FinanceAccountExEntityMapper financeAccountExEntityMapper;

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

    @Override
    public ResultObject invert(Map<String, Object> paramMap) {

        ResultObject resultObject = new ResultObject();
        resultObject.setErrorCode(Constants.SUCCESS);
        LoanInfoEntity  loanInfoEntity = loanInfoEntityMapper.selectByPrimaryKey(Integer.parseInt(paramMap.get("loanId").toString()));
        paramMap.put("version",loanInfoEntity.getVersion());

        int updataLeftInfoMoneyCount =  loanInfoExEntityMapper.updataleftInfoMoneyByLoanId(paramMap);

        if (updataLeftInfoMoneyCount > 0) {
            int updatafinanceAccountCount = financeAccountExEntityMapper.updateFinanaceAccountByUid(paramMap);
            if (updatafinanceAccountCount > 0) {
                BidInfoEntity paramBidInfoEntity = new BidInfoEntity();
                paramBidInfoEntity.setBidmoney(Double.parseDouble(paramMap.get("bidMoney").toString()));
                paramBidInfoEntity.setBidtime(new Date());
                paramBidInfoEntity.setLoanid(loanInfoEntity.getId());
                paramBidInfoEntity.setUid(Integer.parseInt(paramMap.get("uid").toString()));
                paramBidInfoEntity.setBidstatus(1);
                int insertSelective = bidInfoEntityMapper.insertSelective(paramBidInfoEntity);
                if (insertSelective > 0) {
                    LoanInfoEntity loanInfoEntity1 = loanInfoEntityMapper.selectByPrimaryKey(Integer.parseInt(paramMap.get("loanId").toString()));
                    if (loanInfoEntity1.getLeftProductMoney() == 0) {
                        LoanInfoEntity updateLoanInfo = new LoanInfoEntity();
                        updateLoanInfo.setProductStatus(1); //0 未满标  1 已满标 2 满标且生成收益计划
                        updateLoanInfo.setProductFullTime(new Date());
                        updateLoanInfo.setId(loanInfoEntity1.getId());
                        int updateloanInfoCount = loanInfoEntityMapper.updateByPrimaryKeySelective(updateLoanInfo);
                        if ( updateloanInfoCount < 0) {
                            resultObject.setErrorCode(Constants.FALL);
                        }
                    }
                    //为投资排行榜记录数据
                    String phone = (String)paramMap.get("phone");
                    Double bidMoney = (Double)paramMap.get("bidMoney");
                    redisTemplate.opsForZSet().incrementScore(Constants.INVEST_TOP,phone,bidMoney);
                }else{
                    resultObject.setErrorCode(Constants.FALL);
                }
            }else {
                resultObject.setErrorCode(Constants.FALL);
            }
        }else {
            resultObject.setErrorCode(Constants.FALL);
        }
        return resultObject;
    }

    @Override
    public List<BidUserTop> queryBidUserTop() {
        List<BidUserTop> topUserList = new ArrayList<BidUserTop>();

        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().reverseRangeWithScores(Constants.INVEST_TOP, 0, 9);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();

            BidUserTop topUser = new BidUserTop();
            topUser.setPhone((String)typedTuple.getValue());
            topUser.setScore(typedTuple.getScore());

            topUserList.add(topUser);
        }
        return topUserList;
    }

    @Override
    public List<BidInfoExEntity> queryBidInfoListTopByUid(Map<String, Object> paramMap) {
        List<BidInfoExEntity> bidInfoExEntityList = bidInfoExEntityMapper.selectBidInfoListTop(paramMap);
        return bidInfoExEntityList;
    }

    @Override
    public PagenationVO<BidInfoExEntity> queryBidInfoListByUid(Map<String, Object> paramMap) {
        PagenationVO<BidInfoExEntity> pagenationVO = new PagenationVO<>();
        Long bidInfoTotal =  bidInfoExEntityMapper.selectBidInfoByUidTotal(paramMap.get("uid").toString());
        pagenationVO.setToltal(bidInfoTotal);
        List<BidInfoExEntity> bidInfoExEntityList = bidInfoExEntityMapper.selectBidInfoListTop(paramMap);
        pagenationVO.setDateList(bidInfoExEntityList);
        return pagenationVO;
    }
}
