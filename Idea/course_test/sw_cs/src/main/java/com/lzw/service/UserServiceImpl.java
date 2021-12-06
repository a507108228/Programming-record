package com.lzw.service;

import com.lzw.bean.User;
import com.lzw.dao.UserDao;
import com.lzw.dao.UserDaoImpl;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 10:56
 * description
 */
public class UserServiceImpl implements UserService{

    public static UserDao userDao = new UserDaoImpl();

    @Override
    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(int id){
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user){
        return userDao.updateUser(user);
    }

    @Override
    public List<User> selectAllUser(){
        return userDao.selectAllUser();
    }
}
