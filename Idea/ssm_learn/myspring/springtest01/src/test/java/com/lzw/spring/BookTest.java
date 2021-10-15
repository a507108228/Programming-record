package com.lzw.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author: a5071
 * @date: 2021/7/4 18:37
 * @description:
 */
public class BookTest {
    /**
     * @author: a5071
     * @description: set 注入属性 基于xml
     */
    @Test
    public void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.testDemo();

    }
}
