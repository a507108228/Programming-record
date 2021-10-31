package com.atguigu.msm.controller;

import com.atguigu.commonutils.R;
import com.atguigu.msm.service.MsmService;
import com.atguigu.msm.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author a5071
 * @since 2021/10/31 16:01
 * description:
 */
@RestController
@RequestMapping("/edumsm/msm")
@CrossOrigin
public class MsmController{

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("send/{phone}")
    public R sendMsm(@PathVariable String phone){
        // redis获取验证码 有发送没有就走阿里云
        String code = redisTemplate.opsForValue().get(phone);
        if (! StringUtils.isEmpty(code)){
            return R.ok();
        }

        // 生成随机的4位验证码
        code = RandomUtil.getFourBitRandom();
        Map<String, Object> param = new HashMap<>();
        param.put("code", code);

        // 调用service发送短信的方法
        boolean isSend = msmService.send(param, phone);
        if (isSend){
            // 设置时长五分钟 key value timeout
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return R.ok();
        }else {
            return R.error().message("短信发送失败");
        }

    }
}
