package com.lzw.dao;

import com.lzw.pojo.Course;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author: a5071
 * @date: 2021/6/15 19:01
 * @description:
 */
public interface CourseMapper{
    //  模糊查询 where name like #{name}
    List< Course > getCourseByNameLike(String name);

    //  返回一条记录的map，k——v
    Map<String,Object> getCourseByIdReturnMap(Integer id);

    //  多条记录封装一个map
    @MapKey("name") //封装map时 用那个属性作为map的 k 主键
    Map<String,Course> getCourseByNameLikeReturnMap(String name);

}
