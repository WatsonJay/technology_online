package com.learning.techonlinepojo.JwtToken;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JwtTokenBean.java
 * @Description TODO
 * @createTime 2019年08月18日 15:55:00
 */
@ApiModel("JwtToken类")
public class JwtTokenBean implements AuthenticationToken {
    @ApiModelProperty(value = "token", name = "token",dataType = "String", example = "aaa.bbb.ccc")
    private String token;

    public JwtTokenBean(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
