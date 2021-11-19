package com.lzw.controller;

import com.lzw.bean.Tag;
import com.lzw.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author a5071
 * @since 2021/11/18 18:59
 * description
 */
@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController{

    @Autowired
    private TestService testService;

    @GetMapping("getAllTags")
    public List<Tag> getAllTags(){

     return testService.getAllTags();
    }

}
