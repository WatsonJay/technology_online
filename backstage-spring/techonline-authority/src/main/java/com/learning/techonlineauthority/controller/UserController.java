package com.learning.techonlineauthority.controller;

import com.github.pagehelper.PageInfo;
import com.learning.techonlineauthority.service.UserService;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserModifDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserLoginDTO;
import com.learning.techonlinepojo.Authority.User.pojo.dto.UserQueryDTO;
import com.learning.techonlinepojo.Authority.User.pojo.po.UserPO;
import com.learning.techonlinepojo.Request.QueryParam;
import com.learning.techonlinepojo.Response.ResponseBean;
import com.learning.techonlinepojo.ResponseException.ExceptionEnums;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2019年08月01日 00:28:00
 */
@RestController("UserController")
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的 RESTful APIs",value = "UserController")
public class UserController {
    public static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册接口",notes = "用户注册接口")
    @PostMapping(value = "/registerUser")
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "成功", response = ResponseBean.class, responseContainer = "json" ) } )
    @CrossOrigin
    public @ResponseBody Object registerUser(@RequestBody @Validated UserModifDTO userAdd) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            if (userService.getUserNameCount(userAdd.getUserName()) != 0) {
                ResponseBean responseBean=new ResponseBean(false,ExceptionEnums.USER_NAME_EXIST);
                return responseBean;
            } else if (userService.getUserNickNameCount(userAdd.getUserNickName()) != 0) {
                ResponseBean responseBean=new ResponseBean(false,ExceptionEnums.USER_NICKNAME_EXIST);
                return responseBean;
            } else {
                userService.newUser(userAdd);
                ResponseBean responseBean=new ResponseBean(true,ExceptionEnums.SUCCESS);
                return responseBean;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseBean(false, ExceptionEnums.SEVER_ERROR);
        }
    }

    @ApiOperation("用户登陆接口")
    @PostMapping("/login")
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "成功", response = ResponseBean.class, responseContainer = "json" ) } )
    @CrossOrigin
    public Object login(@RequestBody @Validated UserLoginDTO userLogin) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            UserDTO verifyedUser = userService.verifyLoginUser(userLogin);
            if (verifyedUser == null){
                return new ResponseBean<>(false, ExceptionEnums.USER_FAIL);
            }else {
                return new ResponseBean<>(true,verifyedUser,ExceptionEnums.SUCCESS);
            }
        } catch (Exception e) {
            return new ResponseBean<>(false, ExceptionEnums.SEVER_ERROR);
        }
    }

    @ApiOperation(value = "用户查询接口",notes = "用户查询接口")
    @PostMapping(value = "/queryUserList")
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "成功", response = ResponseBean.class, responseContainer = "json" ) } )
    @CrossOrigin
    public ResponseBean<PageInfo<UserPO>> querUserList(@RequestBody @Validated QueryParam<UserQueryDTO> param){
        try {
            PageInfo<UserPO> UserInfo = userService.queryUserList(param.getParam(), param.getPageNum(), param.getPageSize());
            return new ResponseBean<>(true,UserInfo);
        } catch (Exception e) {
            return new ResponseBean<>(false, ExceptionEnums.SEVER_ERROR);
        }
    }
}
