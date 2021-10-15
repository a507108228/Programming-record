package com.lzw.test;

import com.lzw.bean.Books;
import com.lzw.mapper.BookMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class test{

    @Autowired
    BookMapper bookMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testAdd(){
        Books books = new Books(1, "C++从入门到放弃", 99, "根本不看");

        int i = bookMapper.addBook(books);

        if (i > 0) {
            System.out.println("插入成功");
        }
    }


    @Test
    public void testDelete(){
        int i = bookMapper.deleteBookById(6);
        if (i > 0) {
            System.out.println("删除成功");
        }
    }


    @Test
    public void testUpdate(){

        Books books = new Books(5, "C#从入门到放弃", 99, "天天看，但是看不懂");
        int i = bookMapper.updateBook(books);

        if (i > 0) {
            System.out.println("更新完成");
        }
    }


    @Test
    public void testSelect1(){
        List<Books> books = bookMapper.queryAllBook();

        for (Books b : books) {

            System.out.println(b);
        }
    }

    @Test
    public void testSelect2(){
        Books books = bookMapper.queryBookById(5);
        System.out.println(books);
    }

    @Test
    public void insertEmpsBatchTest(){
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        for (int i = 1; i < 10; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            mapper.addBook(new Books(1, uid, 20, "啥也不是"));

        }
    }
}
