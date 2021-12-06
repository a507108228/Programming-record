package com.lzw.ab;


import com.lzw.bean.User;
import com.lzw.dao.UserDao;
import com.lzw.service.UserService;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/3 14:04
 * description
 */
public class test implements UserDao, UserService{

public final int add(int a, int b){
    try {
        return a+b;
    } catch (Exception e){
        System.out.println("catch");
    } finally {
        System.out.println("finally");
    }
    return 0;
}

    public static void main(String[] args){
        test test = new test();
        System.out.println(test.add(9,34));


        String a1 = "abc";
        String a2 = "abc";
        String a3 = "abcd";
        System.out.println(a2.length());
        System.out.println(a1==a2);
        System.out.println(a2==a3);
        System.out.println(a3==a1);

        int a = 2;
        int b = 2;
        String c = "2";
        String d = new String("2");

    }

    @Override
    public int insertUser(User user){
        return 0;
    }

    @Override
    public int deleteUser(int id){
        return 0;
    }

    @Override
    public int updateUser(User user){
        return 0;
    }

    @Override
    public List<User> selectAllUser(){
        return null;
    }
}
