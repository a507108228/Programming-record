package com.lzw.dao;

import com.lzw.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


/**
 * @author: a5071
 * @date: 2021/7/6 21:01
 * @description:
 */
@Repository
public class BookDaoImpl implements BookDao{
    // 注入JdbcTemplate对象
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 增加数据
    @Override
    public void add(Book book){
        String sql = "insert into user values(?,?,?)";
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getPwd());

        System.out.println(update);
    }

    // 批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs){
        String sql = "insert into user values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));

    }

    // 修改数据
    @Override
    public void update(Book book){
        String sql = "update user set name=?,pwd=? where id=?";
        Object[] args = {book.getName(),book.getPwd(),book.getId()};
        int update = jdbcTemplate.update(sql, args);

    }

    // 批量修改
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs){
        String sql = "update user set name=?,pwd=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    // 删除数据
    @Override
    public void delete(Book book){
        String sql = "delete from user where id=?";
        Object[] args = {book.getId()};
        int update = jdbcTemplate.update(sql, args);

    }

    // 批量删除
    @Override
    public void batchDeleteBook(List<Object[]> batchArgs){
        String sql = "delete from user where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    // 查询数据
    @Override
    public int selectCount(){
        String sql = "select count(*) from user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);

        return integer;
    }

    // 查询返回对象
    @Override
    public void selectObject(Book book){
        String sql = "select *from user where id=?";

        Book book1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), book.getId());

        System.out.println(book1);
    }

    // 返回list集合
    @Override
    public List<Book> selectAll(){
        String sql = "select *from user";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }
}
