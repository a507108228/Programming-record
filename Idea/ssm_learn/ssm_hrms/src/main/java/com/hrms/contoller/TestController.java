package com.hrms.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: a5071
 * @date: 2021/8/17 11:18
 * @description:
 */
@Controller
public class TestController{

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index(){
        System.out.println("测试......");
        return "main";
    }
}
