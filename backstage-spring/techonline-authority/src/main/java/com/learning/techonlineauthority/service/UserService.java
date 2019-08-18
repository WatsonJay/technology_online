package com.learning.techonlineauthority.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserAddDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserLoginDTO;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2019年08月15日 16:43:00
 */
public interface UserService extends IService<UserPO> {

    /*
    增加用户
    {user} 要新增的User实例
     */
    public void newUser(UserAddDTO userAdd);

    /*
    根据用户名查询数量
    {userName} 要查询用户的 userName
     */
    public int getUserNameCount(String userName);
    /*
    根据用户昵称查询数量
    {userNickName} 要查询用户的 userNickName
     */
    public int getUserNickNameCount(String userNickName);

    /*
    根据用户昵称查询数量
    {userNickName} 要查询用户的 userNickName
     */
    public UserDTO verifyLoginUser(UserLoginDTO userLogin);
}
