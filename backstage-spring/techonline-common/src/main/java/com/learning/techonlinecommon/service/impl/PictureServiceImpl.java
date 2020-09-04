package com.learning.techonlinecommon.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.techonlineutil.EntityObjectConverter;
import com.learning.techonlineutil.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learning.techonlinecommon.mapper.PictureMapper;
import com.learning.techonlinecommon.service.PictureService;
import com.learning.techonlinepojo.Common.Picture.dto.PictureDTO;
import com.learning.techonlinepojo.Common.Picture.po.PicturePO;
import com.learning.techonlineutil.PicWithSMMS;

import java.io.File;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PictureServiceImpl.java
 * @Description TODO
 * @createTime 2020年03月21日 16:59:00
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, PicturePO> implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public String uploadPicture(MultipartFile multipartFile) {
        String picName = multipartFile.getOriginalFilename();
        File file = FileUtil.toFile(multipartFile);
        if(checkMd5(file)){
            PictureDTO picture = PicWithSMMS.upload(file);
            String picId = IdUtil.simpleUUID();
            // 初始化employee 对象
            PicturePO picturePO = EntityObjectConverter.getObject(picture, PicturePO.class);
            picturePO.setId(picId);
            picturePO.setFileName(picName);
            int ret = pictureMapper.insert(picturePO);
            if(ret==1){
                return picId;
            }
            else {
                return null;
            }
        }
        else {
            return querySameMd5Pic(file);
        }
    }

    public Boolean checkMd5(File file) {
        QueryWrapper<PicturePO> queryWrapper = new QueryWrapper<PicturePO>();
        queryWrapper.eq("md5_code",FileUtil.getMd5(file));
        if(pictureMapper.selectCount(queryWrapper) != 0){
            return false;
        }
        else {
            return true;
        }
    }

    public String querySameMd5Pic(File file) {
        QueryWrapper<PicturePO> queryWrapper = new QueryWrapper<PicturePO>();
        queryWrapper.eq("md5_code",FileUtil.getMd5(file));
        PicturePO picturePO = pictureMapper.selectOne(queryWrapper);
        return picturePO.getId();
    }
}
