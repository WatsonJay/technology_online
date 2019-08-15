package com.learning.techonlineauthority.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.techonlineauthority.mapper.UserMapper;
import com.learning.techonlineauthority.service.UserService;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserAddDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserDTO;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;
import com.learning.techonlineutil.EncodeAndDecode;
import com.learning.techonlineutil.EntityObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserMapper userMapper;

    EncodeAndDecode encodeAndDecode;

    @Override
    public void newUser(UserAddDTO userAdd){
        UserPO user = EntityObjectConverter.getObject(userAdd, UserPO.class);
        UserDTO checkUser = EntityObjectConverter.getObject(userAdd, UserDTO.class);
        String password = encodeAndDecode.AESEncode(checkUser.getPassword());
        if ( password != ""){
            user.setPassword(password);
        }
        userMapper.insert(user);
    }

    /*
    根据用户名查询数量
    {userName} 要查询用户的 userName
     */
    @Override
    public int getUserNameCount(String userName){
        return userMapper.getUserNameCount(userName);
    };
    /*
    根据用户昵称查询数量
    {userNickName} 要查询用户的 userNickName
     */
    @Override
    public int getUserNickNameCount(String userNickName){
        return userMapper.getUserNickNameCount(userNickName);
    };
}
