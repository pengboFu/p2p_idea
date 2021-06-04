package com.bob.p2p.service.loan;


import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.common.core.utils.DateUtils;
import com.bob.p2p.dao.IncomeRecordEntityMapper;
import com.bob.p2p.dao.LoanInfoEntityMapper;
import com.bob.p2p.dao.loan.BidInfoExEntityMapper;
import com.bob.p2p.dao.loan.IncomeRecordExEntityMapper;
import com.bob.p2p.dao.loan.LoanInfoExEntityMapper;
import com.bob.p2p.dao.user.FinanceAccountExEntityMapper;
import com.bob.p2p.model.IncomeRecordEntity;
import com.bob.p2p.model.LoanInfoEntity;
import com.bob.p2p.model.loan.BidInfoExEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("incomRecordServiceImpl")
public class IncomRecordServiceImpl implements IncomRecordService{

    private Logger logger = LogManager.getLogger(IncomRecordServiceImpl.class);

    @Autowired
    private LoanInfoExEntityMapper loanInfoExEntityMapper;

    @Autowired
    private LoanInfoEntityMapper loanInfoEntityMapper;

    @Autowired
    private BidInfoExEntityMapper bidInfoExEntityMapper;

    @Autowired
    private IncomeRecordEntityMapper incomeRecordEntityMapper;

    @Autowired
    private IncomeRecordExEntityMapper incomeRecordExEntityMapper;

    @Autowired
    private FinanceAccountExEntityMapper financeAccountExEntityMapper;

    @Override
    public void ganarateIncomePlan () {

        //查询产品状态为1的产片，返回已满标产品的list
        List<LoanInfoEntity> loanInfoEntityList = loanInfoExEntityMapper.selectLoanInfoByProductStatus(1);
        //循环遍历，获得每一个已满标产品
        for (LoanInfoEntity entity :loanInfoEntityList) {
            //产品类型
            Integer productType =   entity.getProductType();

            //产品满标时间
            Date productFullTime = entity.getProductFullTime();

            //产品周期
            Integer cycle = entity.getCycle();

            //产品利率
            Double rate = entity.getRate();

            //获取当前满标产品的所有投资记录
                List<BidInfoExEntity> bidInfoExEntityList =   bidInfoExEntityMapper.selectBidInfoByLoanId(entity.getId());
                //遍历投资记录获取每条记录
                for (BidInfoExEntity bidInfoExEntity : bidInfoExEntityList){
                    //投资金额
                    Double bidmoney = bidInfoExEntity.getBidmoney();

                    //将当前投资记录生成对应的收益记录
                    IncomeRecordEntity incomeRecordEntity = new IncomeRecordEntity();
                    incomeRecordEntity.setUid(bidInfoExEntity.getUid());
                    incomeRecordEntity.setLoanid(bidInfoExEntity.getLoanid());
                    incomeRecordEntity.setBidid(bidInfoExEntity.getId());
                    incomeRecordEntity.setBidmoney(bidInfoExEntity.getBidmoney());
                    incomeRecordEntity.setIncomestatus(0);//0:未返还 1:已返还
                    //收益时间 =  满表时间 + 投资周期
                    Date incomDate = null;
                    //收益金额 = 投资金额 * 日利率 * 投资天数
                    Double incomMoney = null;
                    if (Constants.PRODUCET_TYPE_S == productType) {
                        //生成收益时间
                        incomDate = DateUtils.getDateByAddDays(productFullTime, cycle);
                        incomMoney = bidmoney * (rate/100/365) * cycle;
                    }else {
                        //生成收益时间
                        incomDate = DateUtils.getDateByMonthes(productFullTime, cycle);
                        incomMoney = bidmoney * (rate/100/365) * cycle * 30;
                    }

                    incomMoney = Math.round(incomMoney * Math.pow(100,2)) / Math.pow(10,2);

                    incomeRecordEntity.setIncomedate(incomDate);
                    incomeRecordEntity.setIncomemoney(incomMoney);
                    int insertCount = incomeRecordEntityMapper.insertSelective(incomeRecordEntity);
                    if (insertCount > 0) {
                        logger.info("用户标识为:"+bidInfoExEntity.getUid()+"投资记录标识为:"+bidInfoExEntity.getLoanid()+"生成成功");
                    }else {
                        logger.info("用户标识为:"+bidInfoExEntity.getUid()+"投资记录标识为:"+bidInfoExEntity.getLoanid()+"生成失败");
                    }
                }
            LoanInfoEntity loanInfoEntity = new LoanInfoEntity();
            loanInfoEntity.setId(entity.getId());
            loanInfoEntity.setProductStatus(2);//2:满标且生成收益计划
            int updateLoanInfoCount = loanInfoEntityMapper.updateByPrimaryKeySelective(loanInfoEntity);
            if (updateLoanInfoCount > 0) {
                logger.info("产品标识为:" +entity.getId()+"修改状态为满标且成功生成收益计划");
            }else {
                logger.info("产品标识为:" +entity.getId()+"修改状态为满标且生成收益计划失败");
            }
        }
    }

    /**
     * 收益返还
     */
    @Override
    public void generateIncomeBack() {

        //查询收益时间与当前收益时间相等且收益状态为0的未返还数据 ---》返回list收益记录
        List<IncomeRecordEntity> incomeRecordList = incomeRecordExEntityMapper.selectIncomeRecordByCurDateAndIncomeStatus(0);

        //循环遍历--》获取每一条收益记录
        for (IncomeRecordEntity incomeRecord : incomeRecordList) {

            //将当前的收益记录收益返还给指定用户的账户，返还金额包含收益   金额+ 本金
            Integer uid = incomeRecord.getUid();//用户标识
            Double bidMoney = incomeRecord.getBidmoney();//投资金额
            Double incomeMoney = incomeRecord.getIncomemoney();//收益金额

            //更新当前用户账户可用余额
            Map<String,Object> paramMap = new ConcurrentHashMap<String,Object>();
            paramMap.put("uid", uid);
            paramMap.put("bidMoney", bidMoney);
            paramMap.put("incomeMoney", incomeMoney);
            int updataFinanceAccountCount = financeAccountExEntityMapper.updataFinanceAccountByIncomeBack(paramMap);

            if(updataFinanceAccountCount > 0){
                //更新当钱收益记录状态为1已返还
                IncomeRecordEntity updataIncomeRecord = new IncomeRecordEntity();
                updataIncomeRecord.setId(incomeRecord.getId());
                updataIncomeRecord.setIncomestatus(1);//更新收益状态为1已返还
                int incomeRecordCount = incomeRecordEntityMapper.updateByPrimaryKeySelective(updataIncomeRecord);

                if(incomeRecordCount > 0 ){
                    logger.info("更新用户"+incomeRecord.getId()+"状态成功");
                }else{
                    logger.info("更新用户"+incomeRecord.getId()+"状态【失败】！");
                }

            }else{
                //
                logger.info("更新收益记录标识为" +incomeRecord.getId() + "失败");
            }
        }
    }
}
