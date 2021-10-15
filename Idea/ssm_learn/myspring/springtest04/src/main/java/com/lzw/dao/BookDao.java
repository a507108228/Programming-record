package com.lzw.dao;

import com.lzw.entity.Book;
import java.util.List;

/**
 * @author: a5071
 * @date: 2021/7/6 21:00
 * @description:
 */
public interface BookDao{

    void add(Book book);
    void update(Book book);
    void delete(Book book);
    int selectCount();
    void selectObject(Book book);
    List<Book> selectAll();
    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
