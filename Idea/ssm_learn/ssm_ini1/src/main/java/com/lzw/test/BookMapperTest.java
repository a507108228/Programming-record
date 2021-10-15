package com.lzw.test;

import com.lzw.bean.Books;
import com.lzw.mapper.BooksMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: a5071
 * @date: 2021/9/11 20:22
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class BookMapperTest{

    @Autowired
    BooksMapper booksMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testSelectAll(){
        List<Books> books = booksMapper.queryAllBook();
        System.out.println(books);
    }


    @Test
    public void testSelectByID(){
        Books books = booksMapper.selectByPrimaryKey(15);
        System.out.println(books);
    }


    @Test
    public void testQueryByID(){
        List<Books> books = booksMapper.queryBookById(15);
        System.out.println(books);
    }

    @Test
    public void testQueryByName(){
        Books books = booksMapper.queryBookByName("挪威的森林");
        Books java = booksMapper.queryBookByName("Java");
        System.out.println(java);
        System.out.println(books);
    }

    @Test
    public void testInsert(){
        int i = booksMapper.insert(new Books(1, "牛津词典", 100, "大牛推荐"));

        if (i > 0) {
            System.out.println("插入成功");
        }

    }

    @Test
    public void testDelete(){
        int i = booksMapper.deleteByPrimaryKey(18);
        if ( i>0 ){
            System.out.println("删除成功");
        }
    }

    @Test
    public void testUpdate(){
        int i = booksMapper.updateByPrimaryKeySelective(new Books(1, "Java", 99, "从入门到放弃就是那么随意"));

        System.out.println(i);
        if( i>0 ){
            System.out.println("更新成功");
        }
    }
}
