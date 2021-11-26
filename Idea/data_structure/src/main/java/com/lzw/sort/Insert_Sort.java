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

}
