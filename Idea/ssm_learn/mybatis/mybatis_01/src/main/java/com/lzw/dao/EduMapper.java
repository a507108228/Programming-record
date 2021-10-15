package com.lzw.dao;

import com.lzw.pojo.Edu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: a5071
 * @version: 2021/6/13 20:01
 */
public interface EduMapper{
    /**
     * @author: a5071
     * @description: 一次查询所有
     */
    List< Edu > getEduList();

    Edu selectEdu(Integer id);  // 指定id查询

    /**
     * @author: a5071
     * @description: 这种查询可太棒了 任何列查询
     */
    @Select("select *from edu where ${column} = ${value} ")
    Edu selectByColumn(@Param("column") String column, @Param("value") String value);

    /**
     * @author: a5071
     * @description: 多条数据插入
     */
    void insertEdu(List< Edu > eduList);

    void addEdu(Edu edu);   //  构造器插入


    void deleteEdu(Integer id); // 指定id删除

    void updateEdu(Edu edu);
}
