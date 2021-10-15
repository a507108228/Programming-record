package com.lzw.dao;

import com.lzw.pojo.Edu;
import com.lzw.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: a5071
 * @version: 2021/6/13 20:22
 */
public class EduMapperTest{


    @Test
    public void testSelect(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            List< Edu > eduList = mapper.getEduList();

            for( Edu edu : eduList ){
                System.out.println(edu);
            }


            /*Edu edu = mapper.selectEdu(1);
            System.out.println(edu);

            //  指定列查询
            Edu edu1 = mapper.selectByColumn("id", "1");
            Edu edu2 = mapper.selectByColumn("name", "'李梓玮'");//  卧槽有病吧 ''这玩意也要有？
            Edu gender = mapper.selectByColumn("gender", "'男'");

            System.out.println(edu1);
            System.out.println(edu2);
            System.out.println(gender);*/

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testAdd(){

        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            // Edu edu = new Edu(null, "张小鱼", "女", "信阳农林", "已毕业");
            // mapper.addEdu(edu);
            List< Edu > eduList = new ArrayList<>();

            Edu edu = new Edu(null, "小一", "男", "郑州财经", "大一");
            Edu edu1 = new Edu(null, "小一", "男", "郑州财经", "大一");
            Edu edu2 = new Edu(null, "小一", "男", "郑州财经", "大一");
            Edu edu3 = new Edu(null, "小一", "男", "郑州财经", "大一");
            Edu edu4 = new Edu(null, "小一", "男", "郑州财经", "大一");

            eduList.add(edu);
            eduList.add(edu1);
            eduList.add(edu2);
            eduList.add(edu3);
            eduList.add(edu4);


            mapper.insertEdu(eduList);

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
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            //  指定id删除
            mapper.deleteEdu(9);

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
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            Edu edu = new Edu(2, "张玉", "女", "信阳农林", "已毕业");
            mapper.updateEdu(edu);

            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}