package com.lzw.dao;

import com.lzw.bean.User;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 10:57
 * description
 */
public interface UserDao{

    int insertUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    List<User> selectAllUser();
}
