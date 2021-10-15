package com.lzw.spring;

/**
 * @author: a5071
 * @date: 2021/7/4 17:33
 * @description: 演示set方法注入
 */
public class Book {
    private String bname;
    private String bautor;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBautor(String bautor) {
        this.bautor = bautor;
    }

    public void testDemo(){
        System.out.println(bname+"---"+bautor);
    }
}
