package com.lzw.lifecycle;

/**
 * @author: a5071
 * @date: 2021/7/5 9:58
 * @description:
 */
public class Order{
    private String oname;

    public Order(){
        System.out.println("1.无参构造创建bean实例");
    }

    public void setOname(String oname){
        this.oname = oname;
        System.out.println("2.set方法设置属性值");
    }

    public void initMethod(){
        System.out.println("3.初始化方法");
    }

    public void destroyMethod(){
        System.out.println("5.销毁方法");
    }
}
