package com.learning.techonlineauthority.controller;

import com.learning.techonlineauthority.service.MenuService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MenuController.java
 * @Description TODO
 * @createTime 2019年08月19日 11:11:00
 */

//@RestController("MenuController")
//@RequestMapping("/menu")
@Api(tags = "菜单相关接口", description = "提供菜单相关的 RESTful APIs",value = "MenuController")
public class MenuController {
    public static Logger logger= LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

//    @ApiOperation(value = "菜单获取接口",notes = "菜单获取接口")
//    @PostMapping(value = "/getMenu")
//    @ApiResponses( value = {
//            @ApiResponse( code = 200, message = "成功", response = ResponseBean.class, responseContainer = "json" ) } )
//    @CrossOrigin
//    public @ResponseBody Object registerUser(@RequestBody @Validated UserModifDTO userAdd) {
//
//    }
}
