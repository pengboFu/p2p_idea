package com.bob.p2p.model.loan;

import com.bob.p2p.model.IncomeRecordEntity;
import com.bob.p2p.model.LoanInfoEntity;

import java.io.Serializable;
import java.util.Date;

public class IncomeRecordExEntity  extends IncomeRecordEntity implements Serializable {

    private LoanInfoEntity loanInfoEntity;

    public LoanInfoEntity getLoanInfoEntity() {
        return loanInfoEntity;
    }

    public void setLoanInfoEntity(LoanInfoEntity loanInfoEntity) {
        this.loanInfoEntity = loanInfoEntity;
    }
}