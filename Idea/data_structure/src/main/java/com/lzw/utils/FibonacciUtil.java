package com.lzw.utils;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author a5071
 * @since 2021/11/27 19:28
 * description
 */
public class FibonacciUtil{

    public static void main(String[] args) throws Exception{

        InputStreamReader is = new InputStreamReader(System.in);

        BufferedReader bs = new BufferedReader(is);

        System.out.println("请输入一个正整数！！");
        String s = bs.readLine();
        int i = Integer.parseInt(s);
        if (i > 0) {
            System.out.println("斐波那契数列递归程序！！");
            System.out.println("fibonacci( "+ i +" )"+" = c"+fibonacci(i));
        } else {
            System.out.println("输入字符无效！！");
        }

        bs.close();
        is.close();
    }

    public static int fibonacci(int n){

        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return (fibonacci(n-1)+fibonacci(n-2));

    }


}
