package Dao;

import utils.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
    private Student user;
    private PreparedStatement pstmt2;
    
    public Student findUser(String name,String Pwd){
    	
    	String sql = "select * from user where username = ? AND userpsw = ?;";
    	pstmt2 = DBUtil.getPstmt(sql);
    	try {
			pstmt2.setString(1, name);
			pstmt2.setString(2, Pwd);
			ResultSet rs = pstmt2.executeQuery(sql);
			if (rs.next()) {
				user = new Student();
				user.setUsername(name);
				user.setPwd(Pwd);
			}else {
				user = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
    }
}
