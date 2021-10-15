package com.lzw.spring;

/**
 * @author: a5071
 * @date: 2021/7/4 18:41
 * @description:
 */
public class Order {
    private String oname;
    private String address;
    // 有参构造
    public Order(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void testDemo(){
        System.out.println(oname+"---"+address);
    }
}
