package com.lzw.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/4 20:47
 * @description: 测试数组集合
 */
public class StuTest{
    /**
     * @author: a5071
     * @description: 测试数组集合
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Student student = context.getBean("student", Student.class);

        student.test();
    }
}
