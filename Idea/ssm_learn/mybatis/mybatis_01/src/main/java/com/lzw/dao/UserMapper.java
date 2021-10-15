package com.lzw.dao;

import com.lzw.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author: a5071
 * @version: 2021/6/13 13:15
 */
public interface UserMapper{
    List< User > getUserList();

    User getUserByMap(Map< String, Object > map);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}
