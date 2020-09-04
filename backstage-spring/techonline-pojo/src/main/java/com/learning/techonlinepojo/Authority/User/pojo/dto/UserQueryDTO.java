package com.learning.techonlinepojo.Authority.User.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserQueryDTO.java
 * @Description TODO
 * @createTime 2019年08月21日 11:13:00
 */
@ApiModel("用户查询DTO")
public class UserQueryDTO {

    @ApiModelProperty(value = "用户ID", name = "id",dataType = "String", example = "1")
    private String id;
    @ApiModelProperty(value = "用户名", name = "userName",dataType = "String", example = "admin")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "用户名存在非法的字符")
    private String userName;
    @ApiModelProperty(value = "用户状态", name = "userStatus",dataType = "Boolean", example = "true")
    private int userStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
