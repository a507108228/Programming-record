package com.lzw.controller;


import org.springframework.web.bind.annotation.*;

/**
 * @author a5071
 * @since 2021/11/20 15:30
 * @description Rest风格的提交方式
 */
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class RestFulController{

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @PutMapping(value = "/user")
    public String putUser(){
        return "PUT-张三";
    }

    @DeleteMapping(value = "/user")
    public String deleteUser(){
        return "DELETE-张三";
    }

}
