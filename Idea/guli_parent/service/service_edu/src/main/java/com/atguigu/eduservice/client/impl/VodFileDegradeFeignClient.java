package com.atguigu.eduservice.client.impl;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author a5071
 * @since 2021/10/26 19:14
 * description: 出错执行
 */
@Component
public class VodFileDegradeFeignClient implements VodClient{

    @Override
    public R removeAlyVideo(String id){
        return R.error().message("删除视频出错");
    }

    @Override
    public R deleteBatch(List<String> videoIdList){
        return R.error().message("删除多个视频出错");
    }
}
