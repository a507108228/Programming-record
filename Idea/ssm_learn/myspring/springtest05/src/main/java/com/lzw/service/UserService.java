package com.lzw.service;

import com.lzw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: a5071
 * @date: 2021/7/9 11:05
 * @description:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE,timeout = -1,readOnly = false)
public class UserService{
    @Autowired
    private UserDao userDao;

    public void acountMon(){
        try {
            userDao.reduceMoney();
            int i = 10/0;
            userDao.addMoney();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
