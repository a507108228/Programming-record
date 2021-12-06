package com.lzw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lzw.bean.Goods;
import com.lzw.util.DB;


public class CopyrightmanagementImp extends Copyrightmanagement{
	public static Vector vec=new Vector();

	Connection conn = DB.getConnection();

	public void Query(String sql) throws SQLException {

		PreparedStatement pra = conn.prepareStatement(sql);

		ResultSet rs = pra.executeQuery();
		vec.removeAllElements();
		while(rs.next()) {
			Vector v = new Vector();
			v.add(rs.getString("名称"));
			v.add(rs.getString("注册日期"));
			v.add(rs.getString("地址"));
			v.add(rs.getInt("电话"));

			vec.add(v);
		}
	}
	public boolean Query1(Copyrightmanagement copyrightmanagement, String sql) throws SQLException {

		PreparedStatement pra = conn.prepareStatement(sql);

		ResultSet rs = pra.executeQuery();

		return false;
	
}
}
