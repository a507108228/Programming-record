package com.lzw.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/4 11:51
 * @description:
 */
public class UserTest {
    /**
     * @author: a5071
     * @description: bean spring 创建对象 无参注入属性
     */
    @Test
    public void testAdd(){
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        // 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }
}
