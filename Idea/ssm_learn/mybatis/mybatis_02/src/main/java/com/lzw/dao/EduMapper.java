package com.lzw.dao;

import com.lzw.pojo.Edu;
import org.apache.ibatis.annotations.Param;

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


    List< Edu > getEduByIf(Edu edu);


    List< Edu > getEduByTrim(Edu edu);

    List< Edu > getEduByChoose(Edu edu);

    void updateEdu1(Edu edu);

//  批量插入
    void addEdu(@Param("edu")List<Edu> edu);


}
