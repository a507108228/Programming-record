package com.atguigu.cms.controller;


import com.atguigu.cms.entity.CrmBanner;
import com.atguigu.cms.service.CrmBannerService;
import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-10-27
 */
@RestController
@RequestMapping("/cms/front")
@Api(description = "用户首页Banner列表")
@CrossOrigin //跨域
public class BannerFrontController{

    @Autowired
    private CrmBannerService bannerService;

    @ApiOperation(value = "获取首页banner")
    @GetMapping("getAllBanner")
    public R index() {
        List<CrmBanner> list = bannerService.selectIndexList();
        return R.ok().data("bannerList", list);
    }
}

