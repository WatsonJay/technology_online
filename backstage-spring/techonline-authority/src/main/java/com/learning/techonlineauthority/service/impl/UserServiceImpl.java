package com.learning.techonlineauthority.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learning.techonlineauthority.mapper.UserMapper;
import com.learning.techonlineauthority.service.UserService;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserModifDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserLoginDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserQueryDTO;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;
import com.learning.techonlineutil.JwtToken;
import com.learning.techonlineutil.EncodeAndDecode;
import com.learning.techonlineutil.EntityObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private UserMapper userMapper;

    @Override
    public void newUser(UserModifDTO userAdd){
        UserPO user = EntityObjectConverter.getObject(userAdd, UserPO.class);
        String password = EncodeAndDecode.AESEncode(userAdd.getPassword());
        if ( password != ""){
            user.setPassword(password);
        }
        user.setUserStatus(1);
        user.setId(IdUtil.simpleUUID());
        userMapper.insert(user);
    }

    @Override
    public int getUserNameCount(String userName){
        return userMapper.getUserNameCount(userName);
    };

    @Override
    public int getUserNickNameCount(String userNickName){
        return userMapper.getUserNickNameCount(userNickName);
    }

    @Override
    public UserDTO verifyLoginUser(UserLoginDTO userLogin) {
        QueryWrapper<UserPO> condition = new QueryWrapper<>();
        String password = EncodeAndDecode.AESEncode(userLogin.getPassword());
        condition.eq("user_name",userLogin.getUserName()).eq("password",password);
        UserPO user = userMapper.selectOne(condition);
        UserDTO loginedUserMsg = EntityObjectConverter.getObject(user, UserDTO.class);
        String userToken = JwtToken.sign(userLogin.getUserName(),userLogin.getPassword());
        loginedUserMsg.setUserToken(userToken);
        return loginedUserMsg;
    }

    @Override
    public PageInfo<UserPO> queryUserList(UserQueryDTO userQuery, int perPage, int perSize) {
        PageHelper.startPage(perPage, perSize);
        QueryWrapper<UserPO> condition = new QueryWrapper<>();
        condition.like("user_name",userQuery.getUserName());
        //condition.eq("user_status",userQuery.isUserStatus());
        List<UserPO> userList = userMapper.selectList(condition);
        PageInfo<UserPO> page = new PageInfo<UserPO>(userList);
        return page;
    }
}
