package com.lzw.pojo;

/**
 * @author: a5071
 * @version: 2021/6/13 13:13
 */
public class User{
    private Integer id;
    private String name;
    private String pwd;

    public User(){
        super();
    }

    public User(Integer id, String name, String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
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
