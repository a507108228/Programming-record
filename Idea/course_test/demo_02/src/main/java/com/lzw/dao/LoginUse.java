package com.lzw.dao;

import com.lzw.bean.User;

import java.sql.SQLException;


public interface LoginUse{
	//查询
	boolean Query(User user, String sql) throws SQLException;

	//增加
	void Add(User user, String sql) throws SQLException;

	void Delete(User user, String sql) throws SQLException;

	//修改
	void Update(User user, String sql) throws SQLException;
}