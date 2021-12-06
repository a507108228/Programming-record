package com.lzw.dao;

import com.lzw.bean.Storage;

import java.sql.SQLException;



public interface Storagemanagement{
    //查询
    public void Query(String sql) throws SQLException;

    //增加
    public void Add(Storage storage, String sql) throws SQLException;

    //删除
    public void Delete(String sql) throws SQLException;

    //修改
    public void Update(Storage storage, String sql) throws SQLException;
}
