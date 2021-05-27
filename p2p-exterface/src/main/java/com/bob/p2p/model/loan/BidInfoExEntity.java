package com.bob.p2p.model.loan;

import com.bob.p2p.model.BidInfoEntity;
import com.bob.p2p.model.UserEntity;

public class BidInfoExEntity extends BidInfoEntity {

    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
