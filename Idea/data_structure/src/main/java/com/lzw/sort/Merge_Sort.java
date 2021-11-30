package com.lzw.sort;

import java.util.Arrays;

/**
 * @author a5071
 * @since 2021/11/28 13:38
 * description 归并排序
 * 时间复杂度：
 * 空间复杂度：需要一个额外空间
 */
public class Merge_Sort{

    public static void main(String[] args){
        int date[] = {5,9,7,4,1,8,2,3,10,0,11,6};
        // 归并排序需要一个额外空间
        int temp[] = new int[date.length];
        System.out.println("排序前："+Arrays.toString(date));
        mergeSort(date, 0, date.length - 1, temp);
        System.out.println("排序后："+Arrays.toString(date));

    }

    // 分 合
    public static void mergeSort(int[] data, int left, int right, int[] temp){

        if (left < right) {
            int mid = (left + right) / 2;
            // 左递归分解
            mergeSort(data, left, mid, temp);
            // 右递归
            mergeSort(data, mid + 1, right, temp);
            // 合并
            merge(data, left, mid, right, temp);
        }
    }

    // 合并
    public static void merge(int[] data, int left, int mid, int right, int[] temp){

        int l = left; // l 左边有序序列的初始索引
        int r = mid + 1; // r 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // 先把左右两边(有序)的数据按照规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完毕为止
        while (l <= mid && r <= right) {
            // 左边的小于等于右边 当前元素填充到temp中
            if (data[l] <= data[r]) {
                temp[t] = data[l];
                t += 1;
                l += 1;
            } else {
                // 右边的小于等于左边 当前元素填充到temp中
                temp[t] = data[r];
                t += 1;
                r += 1;
            }
        }

        // 把有剩余数据的一边的数据依次全部填充到temp
        while (l <= mid) {
            temp[t] = data[l];
            t += 1;
            l += 1;
        }
        while (r <= right) {
            temp[t] = data[r];
            t += 1;
            r += 1;
        }

        // 将temp数组的元素拷贝到arr
        t = 0;
        int temLeft = left;
        while (temLeft <= right) {
            data[temLeft] = temp[t];
            t += 1;
            temLeft += 1;
        }
    }

}
