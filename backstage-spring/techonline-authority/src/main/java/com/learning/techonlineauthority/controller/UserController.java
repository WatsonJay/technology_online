package com.learning.techonlineauthority.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
