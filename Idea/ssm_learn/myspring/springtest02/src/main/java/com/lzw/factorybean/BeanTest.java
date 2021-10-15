package com.lzw.factorybean;

import com.lzw.spring.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: a5071
 * @date: 2021/7/4 21:10
 * @description: FactoryBean 工厂bean 与普通bean不一样
 */
public class BeanTest implements FactoryBean<Course>{

    @Override
    public Course getObject() throws Exception{
        Course course = new Course();
        course.setCname("Linux");
        return course;
    }

    @Override
    public Class<?> getObjectType(){
        return null;
    }

    @Override
    public boolean isSingleton(){
        return FactoryBean.super.isSingleton();
    }
}
