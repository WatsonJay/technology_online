package com.learning.techonlinepojo.Util.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName QueryParam.java
 * @Description TODO
 * @createTime 2019年08月21日 10:59:00
 */

@ApiModel("统一查询封装类")
public class QueryParam<T> implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = -3376666129968410240L;

    @ApiModelProperty(value = "具体参数", name = "param",dataType = "T", example = "")
    private T param;

    @ApiModelProperty(value = "每页数量", name = "pageSize",dataType = "T", example = "")
    private int pageSize;

    @ApiModelProperty(value = "当前页数", name = "pageNum",dataType = "T", example = "")
    private int pageNum;

    public QueryParam(){}

    public QueryParam(T param,int pageSize,int pageNum){
        this.param = param;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "param=" + param +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
