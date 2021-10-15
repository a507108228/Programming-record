package com.lzw.pojo;

import java.math.BigDecimal;

/**
 * @author: a5071
 * @date: 2021/6/15 18:51
 * @description: 课程类
 */
public class Course{
    private Integer id;
    private String name;
    private BigDecimal price;

    public Course(){
        super();
    }

    public Course(Integer id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
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

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
