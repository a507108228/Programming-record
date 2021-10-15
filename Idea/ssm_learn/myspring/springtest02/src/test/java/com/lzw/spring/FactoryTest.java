package com.lzw.spring;

import com.lzw.factorybean.BeanTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/4 21:12
 * @description:
 */
public class FactoryTest{
    /**
     * @author: a5071
     * @description:
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Course beanTest = context.getBean("beanTest", Course.class);

        System.out.println(beanTest);
    }
}
