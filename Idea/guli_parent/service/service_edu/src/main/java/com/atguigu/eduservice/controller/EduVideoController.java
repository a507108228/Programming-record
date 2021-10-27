package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-10-14
 */
@Api(description = "小节管理")
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController{

    @Autowired
    private EduVideoService videoService;

    // 注入vodclient
    @Autowired
    private VodClient vodClient;

    // 添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }

    // 删除小节
    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){

        // 10/25完善删除小节 先删除视频后删除小节
        // 根据小节id获取视频id
        EduVideo eduVideo = videoService.getById(id);

        String videoSourceId = eduVideo.getVideoSourceId();

        if (! StringUtils.isEmpty(videoSourceId)){
            R result = vodClient.removeAlyVideo(videoSourceId);

            if (result.getCode() == 20001){
                throw new GuliException(20001, "删除失败熔断器执行……");
            }
        }

        // 删除小节
        videoService.removeById(id);

        return R.ok();
    }


    // 修改小节
    // 根据id查询小节
    @ApiOperation(value = "查询小节")
    @GetMapping("getVideoById/{id}")
    public R getVideoInfo(@PathVariable String id){

        EduVideo eduVideo = videoService.getById(id);
        return R.ok().data("video",eduVideo);
    }

    @ApiOperation(value = "修改小节")
    @PostMapping("updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){

        videoService.updateById(eduVideo);
        return R.ok();
    }

}




