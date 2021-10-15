package com.lzw.spring;

import com.lzw.bean.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/4 20:13
 * @description:
 */
public class BeanTest {
    /**
     * @author: a5071
     * @description: 内部bean赋值
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.test();
    }
}
