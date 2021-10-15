package com.lzw.spring;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: a5071
 * @date: 2021/7/4 20:33
 * @description: 数组集合都是String类型
 */
public class Student{

    // 数组类型
    private String[] courses;

    // list集合类型
    private List<String> list;

    // map集合类型
    private Map<String, String> map;

    // set集合
    private Set<String> set;

    private List<Course> courseList;

    public void setCourses(String[] courses){
        this.courses = courses;
    }

    public void setList(List<String> list){
        this.list = list;
    }

    public void setMap(Map<String, String> map){
        this.map = map;
    }

    public void setSet(Set<String> set){
        this.set = set;
    }

    public void setCourseList(List<Course> courseList){
        this.courseList = courseList;
    }

    public void test(){
        System.out.println(Arrays.toString(courses));

        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList);
    }

}
