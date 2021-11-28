package com.lzw.utils;

/**
 * @author a5071
 * @since 2021/11/27 19:15
 * description 递归
 */
public class FunUtil{

    public static void main(String[] args){

        System.out.println(fac(24));
    }

    public static int fac(int n){

        if (n == 0) {
            return 1;
        } else {
            return n * fac(n - 1);
        }
    }
}
