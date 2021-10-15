package com.lzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;

/**
 * @author: a5071
 * @date: 2021/8/24 15:37
 * @description:
 */
@Controller
public class IndexController{

    @GetMapping("/test")
    public String test(Model model){

        model.addAttribute("users", Arrays.asList("lzw","zxt","cj","yyw"));
        model.addAttribute("msg","Thymeleaf,hello");
        return "test";

    }
}
