package com.lzw.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/4 18:45
 * @description:
 */
public class OrderTest {
    /**
     * @author: a5071
     * @description: 有参构造注入属性
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Order order = context.getBean("order", Order.class);

        System.out.println(order);
        order.testDemo();
    }
}
