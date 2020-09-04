package com.learning.techonlinepojo.Common.Picture.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PictureDTO.java
 * @Description TODO
 * @createTime 2020年03月21日 17:28:00
 */
public class PictureDTO {

    @ApiModelProperty(value = "图片ID", name = "id",dataType = "String", example = "")
    @TableId(value="id")
    private String id;
    @ApiModelProperty(value = "图片名称", name = "filename",dataType = "String", example = "")
    private String fileName;

    @ApiModelProperty(value = "图片路径", name = "url",dataType = "String", example = "")
    private String url;

    @ApiModelProperty(value = "删除路径", name = "delete",dataType = "String", example = "")
    private String delete;

    @ApiModelProperty(value = "图片MD5", name = "md5Code",dataType = "String", example = "")
    private String md5Code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

}
