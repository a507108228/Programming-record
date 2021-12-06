package com.lzw.controller;


import com.lzw.entity.Person;
import com.lzw.mapper.PersonMapper;
import com.lzw.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzw
 * @since 2021-12-05
 */
@Controller
public class PersonController {

    @Autowired
    private PersonServiceImpl perService;

    @RequestMapping("toUpd")
    public String selectAll(Model model){
        model.addAttribute("list",perService.selectAll());

        return "signup";
    }

    @RequestMapping("update")
    public String update(Person entity){

        int i = perService.updateOne(entity);
        if (i>0){
            System.out.println("成功");
        }

        return "redirect:toUpd";
    }







    // @RequestMapping("/login")
    // public String toLogin(){
    //
    //     return "index";
    // }
    //
    // @PostMapping("/login")
    // public String login(HttpSession session, String username, String password, Model model){
    //
    //     if (! StringUtils.isEmpty(username) && "123456".equals(password)){
    //         return "admin";
    //     }else {
    //         model.addAttribute("msg", "用户名或者密码错误");
    //         return "/login";
    //     }
    // }
}

