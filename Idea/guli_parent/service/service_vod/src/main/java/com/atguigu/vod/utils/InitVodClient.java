package com.atguigu.vod.utils;

import com.aliyun.oss.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author a5071
 * @since 2021/10/23 17:43
 * description:
 */
public class InitVodClient{

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws ClientException{
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }
}
