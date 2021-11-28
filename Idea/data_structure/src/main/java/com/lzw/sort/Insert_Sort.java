package com.lzw.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author a5071
 * @since 2021/11/24 13:54
 * description 插入排序 稳定排序法
 * 空间复杂度：只需要一个额外的空间 O(1)
 * 时间复杂度：O(n)的平方 最好的情况是O(n)
 */
public class Insert_Sort{

    /**
     * @author a5071
     * @description 插入排序
     */
    @Test
    public void testInsert(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int data[] = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        int i, j, temp;
        System.out.println(Arrays.toString(data));
        System.out.println("\n");


        System.out.println("排序开始后：");
        // i从1开始
        for (i = 1; i < data.length; i++) {
            temp = data[i];
            // j要从零开始
            j = i - 1;
            while (j >= 0 && temp < data[j]) {
                // d[j]的值给了
                data[j + 1] = data[j];
                j--;
            }
            // 从while循环出来的j data[j]此时是比temp小或者j已经是最小的位置了
            // 从while出来的j 最小能等于 -1 所以data[j+1]可以从 data[0]开始赋值
            data[j + 1] = temp;
            // 打印每次排序后的数据
            System.out.println(Arrays.toString(data));
        }

        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }


    /**
     * @author a5071
     * description 折半插入排序
     */
    @Test
    public void testBinaryInsert(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss---SSSS");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        System.out.println("排序前：" + Arrays.toString(data));
        System.out.println(" ");

        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int low = 0;
            int high = i - 1;
            while (low <= high){
                int mid = (low + high) / 2;
                if ( data[mid] < temp){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i; j > low; j--) {
                data[j] = data[j - 1];
            }
            data[low] = temp;
            System.out.println(Arrays.toString(data));
        }


        System.out.println(" ");
        System.out.println("排序后：" + Arrays.toString(data));
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss---SSSS");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("花费时间为：" + (end - start) + " ms");
    }

}
