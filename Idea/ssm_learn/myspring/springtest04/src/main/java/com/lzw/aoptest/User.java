package com.lzw.aoptest;

import org.springframework.stereotype.Component;

/**
 * @author: a5071
 * @date: 2021/7/6 16:49
 * @description: 注解操作aop
 */
@Component
public class User{
    // 1 创建类
    public void add(){
        System.out.println("add...");
    }
}
