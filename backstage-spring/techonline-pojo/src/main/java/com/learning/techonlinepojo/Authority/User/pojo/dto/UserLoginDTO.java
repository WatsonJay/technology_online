package com.learning.techonlinepojo.Authority.User.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserLoginDTO.java
 * @Description TODO
 * @createTime 2019年08月18日 13:51:00
 */
@ApiModel("用户登陆DTO")
public class UserLoginDTO {
    /*
            {userName} 用户姓名
            {password} 用户密码
         */
    @ApiModelProperty(value = "用户名", name = "userName",dataType = "String", example = "admin", required = true)
    @Length(min = 3, max = 15, message = "姓名必须在3到15位之间")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "用户名存在非法的字符")
    private String userName;
    @ApiModelProperty(value = "密码", name = "password",dataType = "String", example = "123456", required = true)
    @NotNull(message = "密码不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
