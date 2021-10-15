package com.lzw.service;

import com.lzw.entity.Book;
import com.lzw.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: a5071
 * @date: 2021/7/6 21:02
 * @description:
 */
@Service
public class BookService{

    // 注入bookdao对象
    @Autowired
    private BookDao bookDao;

    public void add(Book book){
        bookDao.add(book);
    }
    public void update(Book book){
        bookDao.update(book);
    }
    public void delete(Book book){
        bookDao.delete(book);
    }
    public int selectCount(){
        return bookDao.selectCount();
    }
    public void selectObject(Book book){
        bookDao.selectObject(book);
    }
    public List<Book> selectAll(){
        return bookDao.selectAll();
    }

    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAddBook(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDeleteBook(batchArgs);
    }


}
