package com.lzw.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a5071
 * @since 2021/11/19 15:13
 * description
 */
@RestController
@RequestMapping("hello")
@CrossOrigin
public class HelloController{

    @GetMapping("/")
    public String test(){

        return "hello world";
    }

}
