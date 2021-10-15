package com.lzw.service;

import com.lzw.bean.Books;
import com.lzw.bean.BooksExample;
import com.lzw.mapper.BooksMapper;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: a5071
 * @date: 2021/9/12 7:36
 * @description:
 */
@Service
public class BooksService{

    @Autowired
    BooksMapper booksMapper;

    public int insert(Books books){
        return booksMapper.insert(books);
    }

    public int deleteByPrimaryKey(Integer bookid){
        return booksMapper.deleteByPrimaryKey(bookid);
    }

    public int updateByPrimaryKeySelective(Books record){
        return booksMapper.updateByPrimaryKeySelective(record);
    }

    public List<Books> queryAllBook(){
        return booksMapper.queryAllBook();
    }

    public List<Books> queryBookById(int id){
        return booksMapper.queryBookById(id);
    }

    public Books queryBookByName(String bookname){
        return booksMapper.queryBookByName(bookname);
    }

    public Books selectByPrimaryKey(Integer bookid){
        return booksMapper.selectByPrimaryKey(bookid);
    }

}
