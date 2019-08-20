package com.learning.techonlineshirojwt;

import com.learning.techonlinepojo.JwtToken.JwtTokenBean;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JwtFilter.java
 * @Description TODO
 * @createTime 2019年08月20日 15:41:00
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {

    //token标识
    private static String LOGIN_SIGN = "Authorization";
    
    /**
     * @title isLoginAttempt
     * @description 检测head中是否包含Authorization,判断用户是否登陆
     * @author jaywatson 
     * @param: [request, response]
     * @updateTime 2019/8/20 16:09 
     * @return: boolean
     * @throws
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response){
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(LOGIN_SIGN);
        return authorization != null;
    }

    /**
     * @title executeLogin
     * @description 执行登陆检测
     * @author jaywatson
     * @param: [request, response]
     * @updateTime 2019/8/20 16:53
     * @return: boolean
     * @throws
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response){
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(LOGIN_SIGN);
        //将token转为shiro的token类
        JwtTokenBean jwtToken = new JwtTokenBean(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request,response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * @title isAccessAllowed
     * @description 判断用户是否有权限
     * @author jaywatson
     * @param: [request, response, mappedValue]
     * @updateTime 2019/8/20 16:58
     * @return: boolean
     * @throws
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            try {
                executeLogin(request, response);
            } catch (Exception e) {
                throw new AuthorizationException(e);
            }
        }
        return true;
    }

    /**
     * @title preHandle
     * @description 对跨域提供支持
     * @author jaywatson 
     * @param: [request, response]
     * @updateTime 2019/8/20 16:57 
     * @return: boolean
     * @throws
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
