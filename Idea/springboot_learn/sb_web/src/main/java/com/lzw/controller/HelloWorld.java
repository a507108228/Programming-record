package com.lzw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: a5071
 * @date: 2021/8/24 11:19
 * @description:
 */
@RestController
public class HelloWorld{

    @GetMapping("hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
