package com.bob.p2p.service.user;

import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.dao.FinanceAccountEntityMapper;
import com.bob.p2p.dao.UserEntityMapper;
import com.bob.p2p.dao.user.UserExEntityMapper;
import com.bob.p2p.model.FinanceAccountEntity;
import com.bob.p2p.model.UserEntity;
import com.bob.p2p.model.VO.ResultObject;
import com.bob.p2p.model.user.UserExEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserExEntityMapper userExEntityMapper;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private FinanceAccountEntityMapper financeAccountEntityMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Integer queryUserTotal() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        BoundValueOperations<Object, Object> boundValueOps = redisTemplate.boundValueOps(Constants.USER_TOTAL);

        Integer userTotal = (Integer) boundValueOps.get();

        if (userTotal == null) {

            userTotal = userExEntityMapper.selectUserTotal();

            redisTemplate.opsForValue().set(Constants.USER_TOTAL,userTotal,15, TimeUnit.MINUTES);
        }

        return userTotal;
    }

    @Override
    public UserExEntity queryIsUserPhone(String phone) {
        return  userExEntityMapper.selectUserByPhone(phone);
    }

    @Override
    public ResultObject register(String phone, String loginpassword) {
        ResultObject resultObject = new ResultObject();
        resultObject.setErrorCode(Constants.SUCCESS);
        UserEntity userEntity =  new UserEntity();
        userEntity.setAddtime(new Date());
        userEntity.setPhone(phone);
        userEntity.setLoginpassword(loginpassword);
        //新增用
       Integer resulNum =  userEntityMapper.insertSelective(userEntity);
        if (resulNum <= 0) {
            resultObject.setErrorCode(Constants.FALL);
            return resultObject;
        }
        UserExEntity userExEntity = userExEntityMapper.selectUserByPhone(phone);
        //新增账户
        FinanceAccountEntity financeAccountEntity = new FinanceAccountEntity();
        financeAccountEntity.setUid(userExEntity.getId());
        financeAccountEntity.setAvailableMoney(888.0);
        financeAccountEntityMapper.insertSelective(financeAccountEntity);
        return resultObject;
    }

    @Override
    public int modifyUserById(UserEntity userParam) {
        return userEntityMapper.updateByPrimaryKeySelective(userParam);
    }

    @Override
    public UserExEntity login(String phone, String loginPassword) {
        UserExEntity userExEntity = userExEntityMapper.selectUserByPhoneAndPsdForLogin(phone,loginPassword);

        if (null != userExEntity) {
            UserEntity userEntityParam = new UserEntity();
            userEntityParam.setId(userExEntity.getId());
            userEntityParam.setLastlogintime(new Date());
            userEntityMapper.updateByPrimaryKeySelective(userEntityParam);

        }
        return userExEntity;
    }
}
