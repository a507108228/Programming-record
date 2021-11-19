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
import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *  redis ：
 *           - @Cacheable    一般用在查询方法第一次查询 没有数据 就查询数据库 查到的数据返回然后放缓存中 以后只要缓存有直接返回数据
 *           - @CachePut    一般用在添加方法上
 *           - @CacheEvict  一般用在更新或者删除方法 清空缓存在更新or删除
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

    @ApiOperation(value = "查询两条banner")
    @GetMapping("getAllBanner")
    public R index() {
        System.out.println("数据库中查询的banner");
        List<CrmBanner> list = bannerService.selectIndexList();
        return R.ok().data("list", list);
    }
}

