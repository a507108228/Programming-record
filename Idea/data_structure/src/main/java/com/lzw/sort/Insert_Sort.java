package com.lzw.sort;

import org.junit.Test;

import java.util.Arrays;

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
    public void test(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int data[] = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        int i, j, temp;
        System.out.println(Arrays.toString(data));
        System.out.println("\n");


        System.out.println("排序开始后：");
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
     * @description 冒泡排序
     */
    @Test
    public void testBs(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int data[] = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        int i, j, temp;
        System.out.println(Arrays.toString(data));
        System.out.println("\n");


        System.out.println("排序开始后：");
        for (i = 0; i < data.length - 1; i++) {
            int flag = 0;
            for (j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag++;
                }
            }
            if (flag == 0) {
                break;
            }

            for (int k = 0; k < data.length; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.println("\n");
        }


        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }

    /**
     * @author a5071
     * @description 选择排序
     */
    @Test
    public void testSe(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int data[] = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        int i, j, temp;
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");

        for (i = 0; i < data.length - 1 ; i++) {
            for (j = i + 1; j < data.length ; j++) {
                if (data[i] > data[j]){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
            for (j = 0; j < data.length ; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }

    /**
     * @author a5071
     * @description 排序
     */
    @Test
    public void testIn(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int data[] = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        int i, j, temp;
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
        for (i = 1; i < data.length ; i++) {
            temp = data[i];
            j = i - 1;
            while (j>=0 && temp<data[j]){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = temp;

            System.out.println(Arrays.toString(data));
        }



        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }
}
