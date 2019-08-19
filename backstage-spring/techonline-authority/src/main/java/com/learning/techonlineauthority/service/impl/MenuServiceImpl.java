package com.learning.techonlineauthority.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.techonlineauthority.mapper.MenuMapper;
import com.learning.techonlineauthority.service.MenuService;
import com.learning.techonlinepojo.Authority.Menu.pojo.po.MenuPO;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MenuServiceImpl.java
 * @Description TODO
 * @createTime 2019年08月19日 11:25:00
 */

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPO> implements MenuService {
}
