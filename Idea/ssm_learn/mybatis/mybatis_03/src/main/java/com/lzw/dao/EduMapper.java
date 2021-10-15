package com.lzw.dao;

import com.lzw.pojo.Edu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: a5071
 * @version: 2021/6/13 20:01
 */
public interface EduMapper{

    List< Edu > getEduList();

    void updateEdu1(Edu edu);

    //    批量插入
    void addEdu(@Param("edu")List<Edu> edu);

    Edu getEduById(Integer id);


}
