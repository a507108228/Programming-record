package com.atguigu.cms.controller;


import com.atguigu.cms.entity.CrmBanner;
import com.atguigu.cms.service.CrmBannerService;
import com.atguigu.commonutils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 首页banner表 后台控制器
 * </p>
 *
 * @author testjava
 * @since 2021-10-27
 */
@Api(description = "管理员首页Banner列表")
@RestController
@RequestMapping("/cms/admin")
@CrossOrigin
public class BannerAdminController{

    @Autowired
    private CrmBannerService bannerService;


    // 分页查询banner
    @ApiOperation("分页查询banner")
    @GetMapping("pageBanner/{current}/{limit}")
    public R pageBanner(@PathVariable long current, @PathVariable long limit ){

        Page<CrmBanner> bannerPage = new Page<>(current, limit);

        bannerService.page(bannerPage, null);

        List<CrmBanner> records = bannerPage.getRecords();
        System.out.println("records==================>"+records);
        long total = bannerPage.getTotal();
        System.out.println("total===================>"+total);

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("查询banner")
    @GetMapping("getBanner/{id}")
    public R getBanner(@PathVariable String id){
        CrmBanner id1 = bannerService.getById(id);
        return R.ok().data("id1", id1);
    }

    // 添加
    @ApiOperation("添加banner")
    @PostMapping("addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner){
        bannerService.save(crmBanner);
        return R.ok();
    }

    // 删除
    @ApiOperation("删除banner")
    @DeleteMapping("deleteBanner/{id}")
    public R deleteBanner(@PathVariable String id){
        bannerService.removeById(id);
        return R.ok();
    }

    // 修改
    @ApiOperation("修改banner")
    @PutMapping("updateBanner")
    public R updateBanner(@RequestBody CrmBanner crmBanner){
        bannerService.updateById(crmBanner);

        return R.ok();
    }
}

