package com.lzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author a5071
 * @since 2021/11/22 10:35
 * description
 */
@Controller
@CrossOrigin
@RequestMapping("thy")
public class HelloController{

    @GetMapping("hello")
    public String hello(Map<String, Object> map, Model model){
        // th:text="${msg}"
        map.put("msg", "改变后的文本值");

        // th:href="${link}" th:href="@{link}"
       model.addAttribute("link","http://www.lzzy2020.xyz/resume");
        return "success";
    }
}
