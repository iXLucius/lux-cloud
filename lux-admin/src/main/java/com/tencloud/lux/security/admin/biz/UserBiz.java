package com.tencloud.lux.security.admin.biz;

import com.tencloud.lux.cache.annotation.Cache;
import com.tencloud.lux.cache.annotation.CacheClear;
import com.tencloud.lux.security.admin.entity.User;
import com.tencloud.lux.security.admin.mapper.MenuMapper;
import com.tencloud.lux.security.admin.mapper.UserMapper;
import com.tencloud.lux.security.auth.client.jwt.UserAuthUtil;
import com.tencloud.lux.security.common.biz.BaseBiz;
import com.tencloud.lux.security.common.constant.UserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper,User> {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserAuthUtil userAuthUtil;
    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    @CacheClear(pre="user{1.username}")
    public void updateSelectiveById(User entity) {
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Cache(key="user{1}")
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }


}
