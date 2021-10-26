package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author a5071
 * @since 2021/10/25 20:08
 * description:
 */
@FeignClient("service-vod")
@Component
public interface VodClient{

    // 根据视频id删除阿里云视频
    @ApiOperation("删除阿里云视频")
    @DeleteMapping("/eduvod/video/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id); //PathVariable 里面参数必须写

    // 删除多个视频
    @ApiOperation("删除多个视频")
    // 改成完全路径
    @DeleteMapping("/eduvod/video/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);
}
