package com.lzw.service;

import com.lzw.dao.UserDao;
import com.lzw.dao.UserDaoImpl;

/**
 * @author: a5071
 * @date: 2021/7/4 19:31
 * @description:
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add ......");
        // 创建UserDao对象
        // UserDaoImpl userDao = new UserDaoImpl();
        userDao.update();
    }
}
