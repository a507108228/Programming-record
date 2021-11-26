package com.lzw.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author a5071
 * @since 2021/11/23 16:33
 * description 冒泡排序 稳定排序法
 * 时间复杂度：O(n)的平方 最好的情况 O(n)
 * 空间复杂度：O(1)
 */
public class Bubble_Sort{

    /**
     * @author a5071
     * @description 普通的冒泡排序
     */
    @Test
    public void testBubble_Sort_01(){
        long start = System.currentTimeMillis();
        int data[] = {6, 5, 9, 7, 2, 8};

        System.out.println("排序前为：");
        for (int k = 0; k < data.length; k++) {
            System.out.print(data[k] + " ");
        }

        System.out.println("\n");
        System.out.println("排序后为：");
        int temp = 0;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }

                System.out.println(Arrays.toString(data));
            }
            System.out.println();
        }

        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
    }

    /**
     * @author a5071
     * @description 改进的冒泡排序
     */
    @Test
    public void testBubble_Sort_02(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int i, j, temp;
        Boolean flag;
        int data[] = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        for ( i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("\n");


        System.out.println("排序开始后：");
        for ( i = 0; i < data.length - 1; i++) {
             flag = true;
            for ( j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j+1]){
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = false;
                }
            }
            if (flag != false){
                break;
            }

            for (j = 0; j < data.length ; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println("\n");
        }


        long end = System.currentTimeMillis();
        System.out.println("排序用时: " + (end - start));
    }
}
