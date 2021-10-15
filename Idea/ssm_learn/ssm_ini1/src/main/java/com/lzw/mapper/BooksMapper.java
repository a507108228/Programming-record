package com.lzw.mapper;

import com.lzw.bean.Books;
import com.lzw.bean.BooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooksMapper {
    long countByExample(BooksExample example);

    int deleteByExample(BooksExample example);

    int insertSelective(Books record);

    List<Books> selectByExample(BooksExample example);

    int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByPrimaryKey(Books record);

    // 查询全部书籍
    List<Books> queryAllBook();

    // 根据id查询书籍
    List<Books> queryBookById(@Param("bookid") int id);

    // 根据名称查询书籍
    Books queryBookByName(@Param("bookname") String bookname);

    Books selectByPrimaryKey(Integer bookid);

    int deleteByPrimaryKey(Integer bookid);

    int insert(Books books);

    int updateByPrimaryKeySelective(Books record);





}