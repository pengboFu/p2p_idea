package com.bob.p2p.service.loan;


import com.bob.p2p.dao.FinanceAccountEntityMapper;
import com.bob.p2p.dao.RechargeRecordEntityMapper;
import com.bob.p2p.dao.loan.RechargeRecordExEntityMapper;
import com.bob.p2p.dao.user.FinanceAccountExEntityMapper;
import com.bob.p2p.model.RechargeRecordEntity;
import com.bob.p2p.model.VO.PagenationVO;
import com.bob.p2p.model.loan.RechargeRecordExEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "rechargeRecordServiceImpl")
public class RechargeRecordServiceImpl implements RechargeRecordService{

    @Autowired
    private RechargeRecordEntityMapper rechargeRecordEntityMapper;

    @Autowired
    private RechargeRecordExEntityMapper rechargeRecordExEntityMapper;

    @Autowired
    private FinanceAccountExEntityMapper financeAccountExEntityMapper;

    @Autowired
    private FinanceAccountEntityMapper financeAccountEntityMapper;

    @Override
    public int addRechargeRecord(RechargeRecordEntity rechargeRecordEntity) {
        return rechargeRecordEntityMapper.insertSelective(rechargeRecordEntity);
    }

    @Override
    public List<RechargeRecordExEntity> queryRechargeRecordListTopByUid(Map<String, Object> paramMap) {
        return rechargeRecordExEntityMapper.selectRechargeRecordListByUid(paramMap);
    }

    @Override
    public PagenationVO<RechargeRecordExEntity> queryRechargeRecordListByUid(Map<String, Object> paramMap) {
        PagenationVO<RechargeRecordExEntity> pagenationVO = new PagenationVO<>();
        Long bidInfoTotal =  rechargeRecordExEntityMapper.selectRechargeRecordByUidTotal(paramMap.get("uid").toString());
        pagenationVO.setToltal(bidInfoTotal);
        List<RechargeRecordExEntity> bidInfoExEntityList = rechargeRecordExEntityMapper.selectRechargeRecordListByUid(paramMap);
        pagenationVO.setDateList(bidInfoExEntityList);
        return pagenationVO;
    }

    @Override
    public int modifyRechargeRecordByRecordNo(RechargeRecordEntity rechargeRecordEntity) {
        return rechargeRecordExEntityMapper.updateRechargeRecordByRecordNo(rechargeRecordEntity);
    }

    @Override
    public int recharge(Map<String, Object> paramMap) {
        //更新账户余额
        int rechargeStatus =  financeAccountExEntityMapper.updateFinanaceAccountByRecharge(paramMap);
        if (rechargeStatus > 0) {
            //更新充值记录状态
            RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
            rechargeRecordEntity.setRechargeno(paramMap.get("rechargeNo").toString());
            rechargeRecordEntity.setRechargestatus("1");
            int status =  rechargeRecordExEntityMapper.updateRechargeRecordByRecordNo(rechargeRecordEntity);
            if (status < 0) {
                return 0;
            }
        }else {
            return 0;
        }
        return 1;
    }
}
