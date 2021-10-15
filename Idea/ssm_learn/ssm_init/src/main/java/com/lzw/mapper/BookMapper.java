package com.lzw.mapper;

import com.lzw.bean.Books;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: a5071
 * @date: 2021/8/22 10:39
 * @description:
 */
public interface BookMapper{

    // 增加一本书
    int addBook(Books book);

    // 根据id删除一本书
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books book);

    // 根据id查询一本书
    Books queryBookById(@Param("bookID") int id);

    // 查询全部book，返回list集合
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName") String bookName);

}

