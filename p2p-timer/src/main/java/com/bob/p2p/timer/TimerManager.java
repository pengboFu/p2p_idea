package com.bob.p2p.timer;


import com.bob.p2p.service.loan.IncomRecordService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class TimerManager {

    @Autowired
    private IncomRecordService incomRecordService;

    private Logger logger = LogManager.getLogger(TimerManager.class);

//    @Scheduled(cron = "0/5 * * * * ?")
//    public void  test(){
//        logger.info("-----------测试开始----------");
//        Double incomMoney = 8.054794520547945E-4;
//        incomMoney = Math.round(incomMoney * Math.pow(10,2)) / Math.pow(10,2);
//        logger.info("adsfasf"+incomMoney);
//        logger.info("-----------测试结束----------");
//    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void ganarateIncomePlan(){
        logger.info("-----------生成收益计划开始----------");
        incomRecordService.ganarateIncomePlan();
        logger.info("-----------生成收益计划结束----------");

    }


    @Scheduled(cron = "0/5 * * * * ?")
    public void ganarateIncomBack(){
        logger.info("-----------收益返还开始----------");
        incomRecordService.generateIncomeBack();
        logger.info("-----------收益返还结束----------");

    }

    public static void  main(String args[]){
        Double incomMoney =  8.054794520547945E-4;
        incomMoney = Math.round(incomMoney * Math.pow(100,2)) / Math.pow(10,2);
        System.out.println(incomMoney);

    }
}
