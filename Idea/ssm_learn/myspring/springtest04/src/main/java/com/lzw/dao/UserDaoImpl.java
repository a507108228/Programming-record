package com.lzw.dao;

import org.springframework.stereotype.Component;

/**
 * @author: a5071
 * @date: 2021/7/5 19:58
 * @description:
 */

@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void add(){
        System.out.println("UserDaoImpl覆写UserDao  add......");
    }
}
