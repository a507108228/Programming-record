package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author a5071
 * @since 2021/10/13 18:07
 * description:
 */
public interface OssService{

    // 上传文件到接口
    String uploadFileAvatar(MultipartFile file);
}
