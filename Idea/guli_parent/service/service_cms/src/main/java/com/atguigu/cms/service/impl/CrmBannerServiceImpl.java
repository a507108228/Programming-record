package com.atguigu.cms.service.impl;

import com.atguigu.cms.entity.BannerQuery;
import com.atguigu.cms.entity.CrmBanner;
import com.atguigu.cms.mapper.CrmBannerMapper;
import com.atguigu.cms.service.CrmBannerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-10-27
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectIndexList(){
        // 根据id降序排列，显示前两条记录
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        wrapper.last("limit 10");

        List<CrmBanner> list = baseMapper.selectList(wrapper);
        return list;
    }


    @Override
    public Page getBannerQuery(long current, long limit, BannerQuery bannerQuery){

        Page<CrmBanner> pageBanner = new Page<>(current, limit);
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();

        String title = bannerQuery.getTitle();
        String url = bannerQuery.getLinkUrl();
        String begin = bannerQuery.getBegin();
        String end = bannerQuery.getEnd();

        if (! StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (! StringUtils.isEmpty(url)) {
            wrapper.eq("link_Url", url);
        }
        if (! StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (! StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }

        // 排序
        wrapper.orderByDesc("gmt_create");

        this.page(pageBanner, wrapper);

        return pageBanner;
    }
}
