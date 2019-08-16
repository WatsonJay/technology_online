package com.learning.techonlinepojo.Authority.User.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserPO.java
 * @Description TODO
 * @createTime 2019年08月15日 15:58:00
 */

@ApiModel("用户实体PO")
@TableName(value = "t_user")
public class UserPO {
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
    @ApiModelProperty(value = "用户ID", name = "id",dataType = "int", example = "1")
    @TableId(value="id",type= IdType.AUTO)
    private int id;
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
    private boolean userStatus;
    @ApiModelProperty(value = "头像名称", name = "picName",dataType = "String", example = "user")
    private String picName;
    @ApiModelProperty(value = "头像图床地址", name = "userPicUrl",dataType = "String", example = "xxx")
    private String userPicUrl;
    @TableField(value = "pic_del_url")
    @ApiModelProperty(value = "头像删除地址", name = "userPicDelUrl",dataType = "String", example = "xxx")
    private String userPicDelUrl;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public boolean isUserStatus() {
        return userStatus;
    }
    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    public String getPicName() {
        return picName;
    }
    public void setPicName(String picName) {
        this.picName = picName;
    }
    public String getUserPicUrl() {
        return userPicUrl;
    }
    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }
    public String getUserPicDelUrl() {
        return userPicDelUrl;
    }
    public void setUserPicDelUrl(String userPicDelUrl) {
        this.userPicDelUrl = userPicDelUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", password='" + password + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userStatus=" + userStatus +
                ", picName='" + picName + '\'' +
                ", userPicUrl='" + userPicUrl + '\'' +
                ", userPicDelUrl='" + userPicDelUrl + '\'' +
                '}';
    }
}
