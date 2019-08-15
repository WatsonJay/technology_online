package com.learning.techonlineauthority.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2019年08月15日 15:55:00
 */

public interface UserMapper extends BaseMapper<UserPO> {

    /*
    根据用户名查询数量
    {userName} 要查询用户的 userName
     */
    int getUserNameCount(String userName);
    /*
    根据用户昵称查询数量
    {userNickName} 要查询用户的 userNickName
     */
    int getUserNickNameCount(String userNickName);

}
