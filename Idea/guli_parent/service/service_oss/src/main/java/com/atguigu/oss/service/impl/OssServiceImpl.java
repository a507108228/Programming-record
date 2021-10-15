package com.atguigu.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author a5071
 * @since 2021/10/13 18:08
 * description:
 */
@Service
public class OssServiceImpl implements OssService{


    @Override
    public String uploadFileAvatar(MultipartFile file){


        String endpoint = ConstantPropertiesUtils.END_POINT;

        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;

        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;

        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;


        InputStream inputStream = null;
        try {

            // 创建OSS实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 获取文件上传输入流
            inputStream = file.getInputStream();

            // 获取文件名称
            String filename = file.getOriginalFilename();

            // 上传重复文件 而不是覆盖
            String uuid = UUID.randomUUID().toString().replaceAll("-","");

            filename = uuid + filename;

            // 把文件按照日期分类
            String datePath = new DateTime().toString("yyyy/MM/dd");

            // 拼接
            filename = datePath + "/" + filename;

            // bucket名称 文件路径和文件名称 上传文件输入流
            ossClient.putObject(bucketName, filename, inputStream);

            // 关闭OSSClient
            ossClient.shutdown();

            // 把上传的文件路径返回 把上传阿里云oss路径拼接出来
            // https://guli-lw.oss-cn-beijing.aliyuncs.com/%E8%B7%AF%E7%BA%BF.png

            String url = "https://"+bucketName+"."+endpoint+"/"+filename;

            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
