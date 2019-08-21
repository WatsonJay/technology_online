package com.learning.techonlineshirojwt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learning.techonlineauthority.service.UserService;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;
import com.learning.techonlinepojo.JwtToken.JwtTokenBean;
import com.learning.techonlineutil.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CustomRealm.java
 * @Description TODO
 * @createTime 2019年08月20日 15:42:00
 */
public class CustomRealm extends AuthorizingRealm {
    public static Logger logger= LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JwtTokenBean;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        logger.info("doGetAuthorizationInfo+" + principals.toString());
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        String username = JwtToken.getUsername(principals.toString());
        queryWrapper.eq("user_name",username);
        UserPO user = userService.getOne(queryWrapper);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String token = (String) authcToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtToken.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        UserPO user = userService.getOne(queryWrapper);
        // 用户不会空
        if (user != null) {
            // 判断是否禁用
            if (!user.isUserStatus()) {
                throw new AuthenticationException("901");
            }
            // 密码验证
            if (!JwtToken.verify(token, username, user.getPassword())) {
                throw new AuthenticationException("900");
            }
            return new SimpleAuthenticationInfo(token, token, "realm");
        } else {
            throw new AuthenticationException("900");
        }
    }
}
