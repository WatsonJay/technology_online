package com.learning.techonlineauthority.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.techonlineauthority.mapper.UserMapper;
import com.learning.techonlineauthority.service.UserService;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserAddDTO;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2019年08月15日 16:44:00
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

    @Override
    public void newUser(UserAddDTO userAdd){
        UserPO user = EntryObjectConverter
    }
}
