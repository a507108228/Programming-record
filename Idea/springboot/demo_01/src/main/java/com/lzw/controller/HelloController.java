package com.lzw.controller;


import com.lzw.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Person person;

    @GetMapping("/")
    public String test(){

        return "你好世界，hello world+123465+*&^%$#@!";
    }

    @GetMapping("/person")
    public Person person(){

        return person;
    }

}
