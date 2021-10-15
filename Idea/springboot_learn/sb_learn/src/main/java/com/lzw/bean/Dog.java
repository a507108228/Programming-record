package com.lzw.bean;

import org.springframework.stereotype.Component;

/**
 * @author: a5071
 * @date: 2021/8/24 9:40
 * @description:
 */
@Component
public class Dog{
    private String name;
    private int age;

    public Dog(){
    }

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
