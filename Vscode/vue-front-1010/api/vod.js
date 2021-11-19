import request from "@/utils/request"
export default {
  getPlayAuth(vid){ //根据视频id获取凭证
    return request({
      url:'/eduvod/video/getPlayAuth/'+vid,
      method:'get',
    })
  },
}