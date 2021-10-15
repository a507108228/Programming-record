package com.lzw.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: a5071
 * @date: 2021/7/9 11:05
 * @description:
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney(){
        String sql = "update course set price = course.price + ? where name = ?";
        int liziwei = jdbcTemplate.update(sql, 100, "liziwei");

        System.out.println(liziwei);
    }

    @Override
    public void reduceMoney(){
        String sql = "update course set price = course.price - ? where name = ?";
        int lizi = jdbcTemplate.update(sql, 100, "lizi");

        System.out.println(lizi);
    }
}
