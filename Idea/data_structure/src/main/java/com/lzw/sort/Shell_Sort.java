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
public class Shell_Sort{

    /**
     * @author a5071
     * @description 希尔排序
     * 五条数据 比较两次就出来了  插入排序比较了四次
     */
    @Test
    public void testShell(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }

        System.out.println("随机数组排序后：");
        System.out.println("\n");

        int i; // 定义外层循环
        int j; // 比较
        int temp; // 暂存比较值
        int jmp = data.length / 2;

        while (jmp != 0) {

            for (i = jmp; i < data.length; i++) {
                temp = data[i];
                j = i - jmp; // 设置初始j是从零开始  i从jmp往上加 i=6的时候 j=1
                while (j >= 0 && temp < data[j]) {
                    // 插入排序的原理
                    data[j + jmp] = data[j];
                    j -= jmp;
                }
                data[j + jmp] = temp;

            }
            System.out.println(Arrays.toString(data));
            System.out.println("");

            jmp /= 2;
        }

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("花费时间为：" + (end - start) + " ms");
    }


    /**
     * @author a5071
     * @description 插入排序
     */
    @Test
    public void testInsert(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }

        System.out.println("随机数组排序后：");
        System.out.println("\n");

        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;

            System.out.println(Arrays.toString(data));
            System.out.println("");
        }

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("花费时间为：" + (end - start) + " ms");
    }

}
