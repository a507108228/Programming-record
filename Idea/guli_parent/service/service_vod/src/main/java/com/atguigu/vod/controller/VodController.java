package com.atguigu.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVodUtils;
import com.atguigu.vod.utils.InitVodClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(description = "视频上传")
@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    // 上传视频到阿里云
    @ApiOperation(value = "上传视频到阿里云")
    @PostMapping("uploadAlyiVideo")
    public R uploadAlyiVideo(MultipartFile file) {
        //返回上传视频id
        String videoId = vodService.uploadVideoAly(file);
        return R.ok().data("videoId",videoId);
    }

    // 根据视频id删除阿里云视频
    @ApiOperation(value = "删除阿里云视频")
    @DeleteMapping("removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable String id){

        try {
            // 初始化对象
            DefaultAcsClient client = InitVodClient
                    .initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);

            // 创建删除视频request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 向request设置视频id
            request.setVideoIds(id);
            // 调用初始化对象的方法实现删除
            client.getAcsResponse(request);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GuliException(20001, "删除失败");
        }
    }

    // 删除多个视频
    @ApiOperation("删除多个视频")
    @DeleteMapping("delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList){

        vodService.removeMoreAlyVideo(videoIdList);
        return R.ok();
    }
}
