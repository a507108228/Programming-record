package com.lzw.sort;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author a5071
 * @since 2021/11/24 10:41
 * description 选择排序 不稳定排序
 * 空间复杂度：空间复杂度为最佳 只需要一个额外空间O(1)
 * 时间复杂度：O(n)的平方
 */
public class Select_Sort{

    /**
     * @author a5071
     * @description 选择排序
     */
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int data[] = {26, 5, 37, 1, 61, 62, 0, 99, 45, 46, 33, 34, 100, 101, 102};
        int i, j, temp;
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
        // data.length - 1是因为最后一个元素没必要比较了
        // 拿第一个元素同后面所有元素比较 谁最小谁放最前面
        for (i = 0; i < data.length - 1; i++) {
            int flag = 0;
            for (j = i + 1; j < data.length; j++) {
                // 交换元素 最小的放前面
                if (data[i] > data[j]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    flag++;
                }
            }
            if (flag == 0) break;
            System.out.println(Arrays.toString(data));
        }
        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }

}
