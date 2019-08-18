package com.learning.techonlinepojo.JwtToken;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JwtTokenBean.java
 * @Description TODO
 * @createTime 2019年08月18日 15:55:00
 */
@ApiModel("JwtToken类")
public class JwtTokenBean {
    @ApiModelProperty(value = "token", name = "token",dataType = "String", example = "xxx")
    private String token;

    public String getToken() {
        return token;
    }
}
