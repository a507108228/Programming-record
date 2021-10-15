package com.lzw.dao;

import com.lzw.pojo.Edu;
import com.lzw.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: a5071
 * @date: 2021/6/18 14:29
 * @description:
 */
public class EduMprTest{

    /**
     * @author: a5071
     * @description: 动态sql查询
     */
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            List< Edu > eduList = mapper.getEduList();

            for( Edu edu : eduList ){
                System.out.println(edu);
            }
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * @author: a5071
     * @description: if动态sql
     */
    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            Edu edu = new Edu(null, "%小%", null, null, null);

            List< Edu > eduByIf = mapper.getEduByIf(edu);

            for( Edu edu1 : eduByIf ){
                System.out.println(edu1);
            }

            System.out.println(
                    "************************************");
            List< Edu > eduByTrim = mapper.getEduByTrim(edu);
            for( Edu edu1 : eduByTrim ){
                System.out.println(edu1);
            }

            System.out.println(
                    "************************************");

            List< Edu > eduByChoose = mapper.getEduByChoose(edu);
            for( Edu edu2 : eduByChoose ){
                System.out.println(edu2);
            }

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * @author: a5071
     * @description: 更新
     */
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            Edu edu = new Edu(1, "李梓", "男", "郑州大学", "未入学");
            mapper.updateEdu1(edu);

            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * @author: a5071
     * @description: 批量插入
     */
    @Test
    public void test4(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);
            ArrayList< Edu > edu = new ArrayList<>();
            edu.add(new Edu(null,"张三","男","国防科技大学","已毕业"));
            edu.add(new Edu(null,"李四","女","国防科技大学","已毕业"));


            mapper.addEdu(edu);

            List< Edu > eduList = mapper.getEduList();
            for( Edu edu1 : eduList ){
                System.out.println(edu1);
            }


            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
