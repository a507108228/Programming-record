package com.lzw;

import com.lzw.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/9 11:16
 * @description: 事务测试
 */
public class TestService{

    /**
     * @author: a5071
     * @description:
     */
    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        UserService userService = context.getBean("userService", UserService.class);

        userService.acountMon();

    }
}
