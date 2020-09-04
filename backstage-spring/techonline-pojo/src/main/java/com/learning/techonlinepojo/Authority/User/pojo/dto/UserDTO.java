package com.learning.techonlinepojo.Authority.User.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserDTO.java
 * @Description TODO
 * @createTime 2019年08月15日 17:48:00
 */
@ApiModel("用户DTO")
public class UserDTO {
    /*
            {id} 自增主键
            {userName} 用户姓名
            {userNickName} 用户昵称
            {password} 用户密码
            {userMail} 用户邮箱
            {userPhone} 用户电话
            {userPower} 用户权限
            {userStatus} 用户状态
         */
    @ApiModelProperty(value = "用户ID", name = "id",dataType = "String", example = "1")
    private String id;
    @ApiModelProperty(value = "用户Token", name = "userToken",dataType = "String", example = "AAA.BBB.CCC")
    private String userToken;
    @ApiModelProperty(value = "用户名", name = "userName",dataType = "String", example = "admin")
    private String userName;
    @ApiModelProperty(value = "用户昵称", name = "userNickName",dataType = "String", example = "admin")
    private String userNickName;
    @ApiModelProperty(value = "密码", name = "password",dataType = "String", example = "123456")
    private String password;
    @ApiModelProperty(value = "邮箱", name = "userMail",dataType = "String", example = "1@qq.com")
    private String userMail;
    @ApiModelProperty(value = "手机号", name = "userPhone",dataType = "String", example = "136000000")
    private String userPhone;
    @ApiModelProperty(value = "用户状态", name = "userStatus",dataType = "Boolean", example = "true")
    private int userStatus;
    @ApiModelProperty(value = "图片Id", name = "picId",dataType = "String", example = "user")
    private String picId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserToken() {
        return userToken;
    }
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserNickName() {
        return userNickName;
    }
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public int getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
    public String getPicId() {
        return picId;
    }
    public void setPicId(String picId) {
        this.picId = picId;
    }
}
