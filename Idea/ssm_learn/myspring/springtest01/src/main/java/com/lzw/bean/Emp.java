package com.lzw.bean;

/**
 * @author: a5071
 * @date: 2021/7/4 20:05
 * @description:
 */
public class Emp {
    private String ename;
    private String egender;
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEgender(String egender) {
        this.egender = egender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test(){
        System.out.println(ename+"---"+egender+"---"+dept);
    }
}
