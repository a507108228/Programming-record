import request from '@/utils/request'
export default{

    // 添加banner
    addBannerInfo(bannerInfo){
        return request({
            url: `/cms/admin/addBanner`,
            method: 'post',
            data: bannerInfo
        })
    },

    // 查询banner
    getListBanner(id){
        return request({
            url: `/cms/admin/getBanner/${id}`,
            method: 'get'
        })
    },

    // 更改banner
    updateBannerInfo(bannerInfo){
        return request({
            url: `/cms/admin/updateBanner`,
            method: 'post',
            data: bannerInfo
        })
    },

    // 删除banner
    deleteBanner(id){
        return request({
            url: `/cms/admin/deleteBanner/${id}`,
            method: 'delete',
        })
    },

    // 分页查询 
    getBannerListPage(current, limit, bannerQuery){
        return request({
            url: `/cms/admin/pageBannerCondition/${current}/${limit}`,
            method: 'post',
            data: bannerQuery
        })
    }
    

}