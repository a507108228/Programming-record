package com.lzw.test;

import com.lzw.bean.User;
import com.lzw.service.UserService;
import com.lzw.service.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 11:11
 * description
 */
public class UserTest{

    public static UserService userService = new UserServiceImpl();
    @Test
    public void testInsert(){

        int l = userService.insertUser(new User(0, "lzw", "9980"));

        if (l != 0){
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * @author a5071
     * @description
     */
    @Test
    public void testDelete(){
        int i = userService.deleteUser(7);
        if (i != 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * @author a5071
     * @description
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("zs");
        user.setPwd("7860");
        user.setId(6);
        int i = userService.updateUser(user);

        if (i != 0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }

    /**
     * @author a5071
     * @description
     */
    @Test
    public void test(){
        List<User> users = userService.selectAllUser();
        System.out.println(users);

    }
}
