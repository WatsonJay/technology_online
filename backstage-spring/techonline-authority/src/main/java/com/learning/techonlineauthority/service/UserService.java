package com.learning.techonlineauthority.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserAddDTO;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2019年08月15日 16:43:00
 */
public interface UserService extends IService<UserPO> {

    /**
     * @title newUser
     * @param: [user]
     * @updateTime 2019/8/15 17:51 
     * @return: void
     */
    public void newUser(UserAddDTO userAdd);
}
