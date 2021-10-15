package com.lzw.dao;

import com.lzw.pojo.Edu;
import com.lzw.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: a5071
 * @date: 2021/6/18 14:29
 * @description:
 */
public class EduMprTest {

    /**
     * @author: a5071
     * @description: 动态sql查询
     */
    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            List< Edu > eduList = mapper.getEduList();

            for ( Edu edu : eduList ) {
                System.out.println(edu);
            }
            sqlSession.commit();
        } catch (Exception e){
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
    public void test2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            Edu edu = new Edu(1, "李梓", "男", "郑州大学", "未入学");
            mapper.updateEdu1(edu);

            sqlSession.commit();

        } catch (Exception e){
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
    public void test3() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);
            ArrayList< Edu > edu = new ArrayList<>();
            edu.add(new Edu(null, "张三", "男", "国防科技大学", "已毕业"));
            edu.add(new Edu(null, "李四", "女", "国防科技大学", "已毕业"));

            mapper.addEdu(edu);

            List< Edu > eduList = mapper.getEduList();
            for ( Edu edu1 : eduList ) {
                System.out.println(edu1);
            }

            sqlSession.commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * @author: a5071
     * @description: 缓存
     * 一级缓存：sqlSession级别的缓存
     * 中间加入新的增删改 俩次sqlSession不相同；
     * 查询期间清理缓存
     * 不同的查询 定然不相同 初次查询尚无缓存
     * 二级缓存：namespace
     * 查询一条数据 当前数据会放在当前会话的以及缓存中；
     * 如果会话关闭 则对应的一级缓存的数据会保存在二级缓存中；
     * 不同的namespace 对应不同的map
     */
    @Test
    public void test4() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            Edu byId = mapper.getEduById(1);
            System.out.println(byId);

            // 中间添加数据 导致缓存失效
            // ArrayList< Edu > list = new ArrayList<>();
            // boolean b = list.add(new Edu(null, "李梓玮", "男", "郑州财经学院", "大三"));
            // mapper.addEdu(list);
            // if( b == true ){
            //     System.out.println("添加成功");
            // } else {
            //     System.out.println("添加失败");
            // }

            //    手动清楚缓存 两次的查询结果也不相同
            sqlSession.clearCache();

            Edu byId1 = mapper.getEduById(1);
            System.out.println(byId1);

            System.out.println(byId == byId1);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * @author: a5071
     * @description: 因为不会序列化 二级缓存测试不了
     */
    @Test
    public void test5() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            EduMapper mapper = sqlSession.getMapper(EduMapper.class);

            EduMapper mapper1 = sqlSession.getMapper(EduMapper.class);

            Edu id = mapper.getEduById(1);
            System.out.println(id);

            Edu id1 = mapper1.getEduById(1);
            System.out.println(id1);

            System.out.println(id == id1);


            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
