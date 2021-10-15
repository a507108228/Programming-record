package com.lzw.spring;

/**
 * @author: a5071
 * @date: 2021/7/4 20:53
 * @description:
 */
public class Course{
    private String cname;

    public void setCname(String cname){
        this.cname = cname;
    }

    @Override
    public String toString(){
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
