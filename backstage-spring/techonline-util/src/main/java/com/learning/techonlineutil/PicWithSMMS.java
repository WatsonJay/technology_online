package com.learning.techonlineutil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.learning.techonlinepojo.Common.Picture.dto.PictureDTO;
import com.learning.techonlinepojo.Util.Exception.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.HashMap;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName PicWithSMMS.java
 * @Description TODO
 * @createTime 2020年03月21日 15:33:00
 */
@Component
public class PicWithSMMS {

    private static String url;

    private static String token;

    @Value("${sm.url}")
    public void setUrl(String parm){
        url = parm;
    }

    @Value("${sm.token}")
    public void setToken(String parm){
        token = parm;
    }

    private static final String SUCCESS = "success";

    private static final String CODE = "code";

    private static final String MSG = "message";

    public static PictureDTO upload(File file) {
        HashMap<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("smfile", file);
        // 上传文件
        String result= HttpRequest.post(url + "/upload")
                .header("Authorization", token)
                .header("Content-Type", "multipart/form-data")
                .form(paramMap)
                .timeout(20000)
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if(!jsonObject.get(CODE).toString().equals(SUCCESS)){
            throw new BadRequestException(jsonObject.get(MSG).toString());
        }
        PictureDTO picture = JSON.parseObject(jsonObject.get("data").toString(), PictureDTO.class);
        picture.setMd5Code(FileUtil.getMd5(file));
        picture.setFileName(file.getName());
        return picture;
    }
}
