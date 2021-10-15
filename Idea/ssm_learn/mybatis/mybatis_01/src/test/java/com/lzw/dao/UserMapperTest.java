package com.lzw.dao;

import com.lzw.pojo.User;
import com.lzw.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: a5071
 * @version: 2021/6/13 13:56
 * Mybatis xml配置 增删改查
 */
public class UserMapperTest{

    @Test
    public void test(){

        SqlSession sqlSession = null;


        try{
            //  获取sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //  执行sql
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List< User > userList = mapper.getUserList();

            for( User user : userList ){
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            //  关闭
            sqlSession.close();
        }
    }

    /**
     * @author: a5071
     * @time: 2021/6/13 18:31
     * 测试增删改
     */
    @Test
    public void testAdd(){
        SqlSession sqlSession = null;
        try{
            //  获取连接
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // User user = new User(5,"6","7");
            // mapper.addUser(user);

            User user = new User(null, "6", "7");
            mapper.addUser(user);

            System.out.println(user.getId());

            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = null;
        try{
            //  获取连接
            sqlSession = MybatisUtils.getSqlSession();


            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = new User(1, "11", "11");
            mapper.updateUser(user);

            //  提交改动
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testDelete(){
        SqlSession sqlSession = null;
        try{
            //  获取连接
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.deleteUser(5);

            //  提交改动
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * @author: a5071
     * @description: map 查询
     */
    @Test
    public void testSelectByMap(){

        SqlSession sqlSession = null;
        try{
            //  获取连接
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map< String, Object > map = new HashMap<>();
            //  由于xml文件中写了 必须写满三个参数才能查询
            map.put("id", 1);
            map.put("name", 1);
            map.put("pwd", 1);

            User user = mapper.getUserByMap(map);

            System.out.println(user);


            //  提交改动
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
