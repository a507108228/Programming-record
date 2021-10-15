package com.lzw.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/5 10:41
 * @description:
 */
public class AutoTest{
    /**
     * @author: a5071
     * @description: 自动装配
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Emp emp = context.getBean("emp", Emp.class);

        emp.test();
    }
}
