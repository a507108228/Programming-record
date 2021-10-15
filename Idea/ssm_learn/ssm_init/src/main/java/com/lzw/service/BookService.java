package com.lzw.service;

import com.lzw.bean.Books;
import com.lzw.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: a5071
 * @date: 2021/8/22 14:59
 * @description:
 */
@Service
public class BookService{

    @Autowired
    BookMapper bookMapper;

    public int addBook(Books book){
        return bookMapper.addBook(book);
    }


    public int deleteBookById(int id){
        return bookMapper.deleteBookById(id);
    }


    public int updateBook(Books book){
        return bookMapper.updateBook(book);
    }


    public Books queryBookById(int id){
        return bookMapper.queryBookById(id);
    }


    public List<Books> queryAllBook(){
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName){
        return bookMapper.queryBookByName(bookName);
    }
}

