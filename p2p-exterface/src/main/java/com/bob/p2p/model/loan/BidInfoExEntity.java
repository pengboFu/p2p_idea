package com.bob.p2p.model.loan;

import com.bob.p2p.model.BidInfoEntity;
import com.bob.p2p.model.LoanInfoEntity;
import com.bob.p2p.model.UserEntity;

public class BidInfoExEntity extends BidInfoEntity {

    private UserEntity userEntity;

    private LoanInfoEntity loanInfoEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LoanInfoEntity getLoanInfoEntity() {
        return loanInfoEntity;
    }

    public void setLoanInfoEntity(LoanInfoEntity loanInfoEntity) {
        this.loanInfoEntity = loanInfoEntity;
    }
}
