package com.lzw.spring;

import com.lzw.aoptest.User;
import com.lzw.entity.Book;
import com.lzw.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author: a5071
 * @date: 2021/7/5 19:00
 * @description:
 */
public class TestDemo{

    /**
     * @author: a5071
     * @description: 注解配置spring 创建对象
     */
    @Test
    public void testUserService(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();
    }

    /**
     * @author: a5071
     * @description: aop 注解测试
     */
    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        User user = context.getBean("user", User.class);

        user.add();
    }

    /**
     * @author: a5071
     * @description: 数据库JdbcTemplate操作数据库之增删改
     */
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);


        Book book = new Book(12,"liziwi","131420");

        bookService.add(book);

    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);


        Book book = new Book(12,"limou","520");

        bookService.update(book);

    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);


        Book book = new Book();
        book.setId(12);

        bookService.delete(book);

    }

    // 查询 按照id查询 返回数据条总数 返回list集合
    @Test
    public void testSelectCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);


        Book book = new Book();
        book.setId(2);
        System.out.println("按照id查询");
        bookService.selectObject(book);

        int i = bookService.selectCount();
        System.out.println("数据总数："+i);

        List<Book> books = bookService.selectAll();

        System.out.println("查询所有："+books);

    }
    // 批量添加
    @Test
    public void testBatchAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> objects = new ArrayList<>();
        Object[] o1 = {"22","liziwei","2020"};
        Object[] o2 = {"33","lizi","2020"};
        objects.add(o1);
        objects.add(o2);

        bookService.batchAdd(objects);
    }

    // 批量修改
    @Test
    public void testBatchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> objects = new ArrayList<>();
        Object[] o1 = {"liziwei","2020","1"};
        Object[] o2 = {"lizi","2020","2"};
        objects.add(o1);
        objects.add(o2);

        bookService.batchUpdate(objects);
    }

    // 批量删除
    @Test
    public void testBatchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> objects = new ArrayList<>();
        Object[] o1 = {"6"};
        Object[] o2 = {"7"};
        objects.add(o1);
        objects.add(o2);

        bookService.batchDelete(objects);
    }


}
