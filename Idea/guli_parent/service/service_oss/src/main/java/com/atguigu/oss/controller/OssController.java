package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author a5071
 * @since 2021/10/13 18:06
 * description:
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin // 跨域
public class OssController{

    @Autowired
    private OssService ossService;


    // 上传头像的方法
    @PostMapping
    public R uploadOssFile(@RequestParam("file") MultipartFile file){

        String url =  ossService.uploadFileAvatar(file);
        return R.ok().data("url", url);
    }
}
