package com.lzw.sort;


import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author a5071
 * @since 2021/11/25 10:32
 * description 快速排序 不稳定排序法
 * 空间复杂度：O(n) 最佳的情况 O(log2n)
 * 时间复杂度：O(nlog2n) 最坏的情况是O(n2)
 */
public class Quick_Sort{

    public static void main(String[] args){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[50000000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        System.out.println("随机数组排序后：");
        System.out.println(" ");

        quick(data, 0, data.length - 1);
        // System.out.println(Arrays.toString(data));
        System.out.println(" ");


        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println(" ");
        System.out.println("花费时间为：" + (end - start) + " ms");

    }

    public static void quick(int[] data, int left, int right){
        int temp;
        int l = left;
        int r = right;
        int mid = data[(left + right) / 2];

        while (l < r) {
            // 下面两个while循环是想找出来
            // 左边大于等于mid的值 和 右边小于等于mid的值 对这俩进行交换
            while (data[l] < mid) {
                l++;
            }

            while (data[r] > mid) {
                r--;
            }
            // 如果l >= r说明mid左右两边值，已经按照左边全部是
            // 小于等于mid值，右边全部是大于等于mid值
            // 因为l++ r-- 从左往右 从右往左
            // 两者相遇的时刻 左右两边的都是已经判定过的
            if (l >= r) {
                break;
            }
            // 普通的交换
            temp = data[l];
            data[l] = data[r];
            data[r] = temp;

            if (data[l] == mid) {
                r--;
            }

            if (data[r] == mid) {
                l++;
            }
        }
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            quick(data, left, r);
        }
        // 向右递归
        if (right > l) {
            quick(data, l, right);
        }
    }

}
