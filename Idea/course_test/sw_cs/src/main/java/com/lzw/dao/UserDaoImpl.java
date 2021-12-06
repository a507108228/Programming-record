package com.lzw.dao;

import com.lzw.bean.User;
import com.lzw.utils.DBUtils;

import java.sql.*;
import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 10:57
 * description
 */
public class UserDaoImpl implements UserDao{


    @Override
    public int insertUser(User user){
        String sql = "insert into user(name, pwd) values(?,?)";
        Connection conn = DBUtils.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getPwd());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, null);
        }
        return - 1;
    }

    @Override
    public int deleteUser(int id){
        String sql = "delete from user where id = ?";
        Connection conn = DBUtils.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, null);
        }
        return - 1;
    }

    @Override
    public int updateUser(User user){
        String sql = "update user set name = ?, pwd = ? where id = ?";
        Connection conn = DBUtils.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPwd());
            ps.setInt(3, user.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, null);
        }
        return - 1;
    }

    @Override
    public List<User> selectAllUser(){
        String sql = "select * from user";
        Connection conn = DBUtils.getConn();
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("pwd");

                User user = new User(id, name, pwd);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, state, rs);
        }
        return null;
    }
}
