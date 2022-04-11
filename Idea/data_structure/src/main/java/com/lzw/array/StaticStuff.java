package com.lzw.array;

/**
 * @author a5071
 * @since 2022/1/16 19:08
 * description
 */
public class StaticStuff{
    static int x = 10;
    static {
        x += 5;
    }

    public static void main(String[] args){
        System.out.println("x=" + x);

    }
    static {
        x /= 3;
    }

    public abstract class Test{
        final void method(){}  
    }
}
