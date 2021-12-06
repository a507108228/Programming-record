package com.lzw.service;

import com.lzw.bean.User;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 10:55
 * description
 */
public interface UserService{

    int insertUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    List<User> selectAllUser();


}
