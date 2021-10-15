package com.lzw.spring;

import com.lzw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author: a5071
 * @date: 2021/7/5 18:59
 * @description:
 */

@Repository
@Controller
@Service
@Component(value = "userService")
public class UserService{

    @Value("李梓玮")
    private String name;
    @Value("男")
    private String gender;
    @Value("22")
    private int age;

    @Autowired
    private UserDao userDao;


    @Override
    public String toString(){
        return "UserService{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", userDao=" + userDao +
                '}';
    }

    public void add(){
        System.out.println("service add...");
        userDao.add();
    }
}
