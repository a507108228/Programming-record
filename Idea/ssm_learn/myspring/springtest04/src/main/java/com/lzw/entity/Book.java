package com.lzw.entity;

import org.springframework.stereotype.Repository;

/**
 * @author: a5071
 * @date: 2021/7/6 21:10
 * @description:
 */

@Repository
public class Book{
    private int id;
    private String name;
    private String pwd;

    public Book(){
    }

    public Book(int id, String name, String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

}
