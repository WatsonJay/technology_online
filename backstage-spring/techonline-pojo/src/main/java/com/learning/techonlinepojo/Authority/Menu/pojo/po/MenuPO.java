package com.learning.techonlinepojo.Authority.Menu.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MenuPO.java
 * @Description TODO
 * @createTime 2019年08月18日 22:32:00
 */

@ApiModel("菜单实体PO")
@TableName(value = "t_menu")
public class MenuPO {
    /*
            {id} 自增主键
            {parentId} 父级菜单id
            {name} 菜单名称
            {path} 菜单路由
            {component} 菜单对应组件
            {icon} 菜单图标
            {chilMenuList} 子菜单列表
         */
    @ApiModelProperty(value = "菜单ID", name = "id",dataType = "int", example = "1")
    @TableId(value="id",type= IdType.AUTO)
    private int id;
    @ApiModelProperty(value = "父级菜单ID", name = "parentId",dataType = "int", example = "1")
    private int parentId;
    @ApiModelProperty(value = "菜单名称", name = "name",dataType = "String", example = "权限管理")
    private int name;
    @ApiModelProperty(value = "菜单路由", name = "path",dataType = "String", example = "/test")
    private String path;
    @ApiModelProperty(value = "菜单对应组件", name = "component",dataType = "String", example = "test")
    private String component;
    @ApiModelProperty(value = "菜单图标", name = "icon",dataType = "String", example = "test")
    private String icon;
    @ApiModelProperty(value = "子菜单列表", name = "icon",dataType = "List", example = "test")
    @TableField(exist = false)
    private List<MenuPO> chilMenuList;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public int getName() {
        return name;
    }
    public void setName(int name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public List<MenuPO> getChilMenuList() {
        return chilMenuList;
    }
    public void setChilMenuList(List<MenuPO> chilMenuList) {
        this.chilMenuList = chilMenuList;
    }
}
