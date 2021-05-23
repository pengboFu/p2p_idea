package com.bob.p2p.service.loan;


import org.springframework.stereotype.Service;

/**
 * 产品信息服务
 */

@Service
public interface LoanInfoService {

    /**
     * 获取历史年化收益率
     * @return
     */
    Double queryHistoryAverageRate();
}
