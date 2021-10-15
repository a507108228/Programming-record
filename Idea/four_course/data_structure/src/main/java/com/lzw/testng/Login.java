package com.lzw.testng;

/**
 * @author: a5071
 * @date: 2021/9/15 15:22
 * @description:
 */
public class Login {

    public boolean logintest(String username,String password)
    {
        boolean flag = false ;
        if(username=="test" && password=="test" )
        {
            flag = true ;
            return flag ;
        }
        else
        {
            return flag ;
        }

    }
}
