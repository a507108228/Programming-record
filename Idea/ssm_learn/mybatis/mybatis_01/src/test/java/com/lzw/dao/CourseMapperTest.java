package com.lzw.dao;

import com.lzw.pojo.Course;
import com.lzw.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author: a5071
 * @date: 2021/6/15 19:09
 * @description:
 */
public class CourseMapperTest{

    /**
     * @author: a5071
     * @description: 测试list like字段 模糊查询
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();

            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

            List< Course > courseByNameLike = mapper.getCourseByNameLike("2");

            System.out.println(courseByNameLike);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    /**
     * @author: a5071
     * @description: Map 指定id查询
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();

            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

            List< Course > like = mapper.getCourseByNameLike("2");
            for( Course course : like ){
                System.out.println(course);
            }

            Map< String, Object > course = mapper
                    .getCourseByIdReturnMap(2);

            System.out.println(course);


            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * @author: a5071
     * @description: Map 多值封装map
     */
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();

            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

            List< Course > like = mapper.getCourseByNameLike("%i%");
            for( Course course : like ){
                System.out.println(course);
            }

            Map< String, Course > map = mapper
                    .getCourseByNameLikeReturnMap("%i%");
            System.out.println(map);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
