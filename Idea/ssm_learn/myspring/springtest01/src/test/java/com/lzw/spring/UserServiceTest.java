package com.lzw.spring;

import com.lzw.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/4 19:55
 * @description:
 */
public class UserServiceTest {
    /**
     * @author: a5071
     * @description:
     */
    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();

    }
}
