package com.lzw.sort;

import java.util.Arrays;

/**
 * @author a5071
 * @since 2021/11/23 16:33
 * description 冒泡排序
 */
public class Bubble_Sort{

    public static void main(String[] args){
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
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }

                System.out.println(Arrays.toString(data));
            }
            System.out.println();
        }

        long end = System.currentTimeMillis();
        System.out.println("用时："+ (end-start) );

    }
}
