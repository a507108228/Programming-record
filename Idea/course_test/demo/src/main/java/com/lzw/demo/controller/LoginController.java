package com.lzw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author a5071
 * @since 2021/11/28 15:23
 * description
 */
@Controller
public class LoginController{

    @GetMapping("login")
    public String login(){

        return "login";
    }
}
