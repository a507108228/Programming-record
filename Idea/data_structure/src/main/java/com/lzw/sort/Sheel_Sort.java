package com.lzw.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author a5071
 * @since 2021/11/24 19:12
 * description 希尔排序 稳定排序
 * 空间复杂度：O(1)
 * 时间复杂度：任何时候都是O(n)的二分之三次方
 */
public class Sheel_Sort{

    /**
     * @author a5071
     * @description 希尔排序
     */
    @Test
    public void test(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间："+format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random()*80000);
        }
        System.out.println(Arrays.toString(data));

        System.out.println("随机数组排序后：");
        System.out.println("\n");





        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间："+format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("花费时间为："+ (end - start) +" ms");
    }

}
