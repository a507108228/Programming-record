package com.lzw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: a5071
 * @date: 2021/8/23 15:51
 * @description:
 */
@RestController
public class HelloSpringBoot{

    @GetMapping("/hello")
    public String hello(){
        return "你好未来";
    }
}
