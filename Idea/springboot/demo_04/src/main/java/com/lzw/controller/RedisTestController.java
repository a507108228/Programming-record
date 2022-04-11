package com.lzw.controller;

import com.lzw.utils.R;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author a5071
 * @since 2021/11/22 10:35
 * description
 */
@RestController
@CrossOrigin
@RequestMapping("/redisTest")
public class RedisTestController{


    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public R getRedis(){
        // 设置值
        redisTemplate.opsForValue().set("name", "lzw");
        redisTemplate.opsForValue().set("age", 100);
        // 取出值
        String name = (String) redisTemplate.opsForValue().get("name");
        Integer age = (Integer) redisTemplate.opsForValue().get("age");

        return R.ok().data("name", name).data("age", age);
    }

}
