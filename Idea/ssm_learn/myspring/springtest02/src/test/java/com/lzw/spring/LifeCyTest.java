package com.lzw.spring;

import com.lzw.lifecycle.Order;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: a5071
 * @date: 2021/7/5 10:05
 * @description: 测试bean的生命周期
 */
public class LifeCyTest{
    /**
     * @author: a5071
     * @description:
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Order lifecycle = context.getBean("lifecycle", Order.class);

        System.out.println("4.获取bean实例对象");
        System.out.println(lifecycle);
        context.close();

    }
}
