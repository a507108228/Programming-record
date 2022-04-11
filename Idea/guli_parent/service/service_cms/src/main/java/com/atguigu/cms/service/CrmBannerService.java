package com.atguigu.cms.service;

import com.atguigu.cms.entity.BannerQuery;
import com.atguigu.cms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-10-27
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> selectIndexList();

    // 分页查询
    Page getBannerQuery(long current, long limit, BannerQuery bannerQuery);
}
