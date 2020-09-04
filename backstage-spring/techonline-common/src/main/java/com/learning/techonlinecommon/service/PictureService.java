package com.learning.techonlinecommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learning.techonlinepojo.Common.Picture.po.PicturePO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PictureService.java
 * @Description TODO
 * @createTime 2020年03月21日 16:59:00
 */
public interface PictureService extends IService<PicturePO> {

    public String uploadPicture(MultipartFile file);
}
