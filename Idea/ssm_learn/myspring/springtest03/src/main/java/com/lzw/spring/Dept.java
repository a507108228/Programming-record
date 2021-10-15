package com.lzw.spring;

/**
 * @author: a5071
 * @date: 2021/7/4 20:05
 * @description:
 */
public class Dept{
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return dname;
    }
}
