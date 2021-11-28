package com.lzw.sort;

import java.util.Arrays;


/**
 * @author a5071
 * @since 2021/11/26 19:49
 * description
 */
public class TotalSort{

    public static void main(String[] args){
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 10000);
        }
        System.out.println("排序之前：" + Arrays.toString(data));

        // heap(data);

        // quick(data, 0, data.length - 1);

        // shell(data);

        // select(data);

        // insert(data);

        // bubble(data);

        System.out.println("排序之后：" + Arrays.toString(data));
    }

    /**
     * @author a5071
     * description 堆排序
     */
    public static void heap(int[] data){
        // 注意此处 end--
        for (int end = data.length - 1; end > 0; end--) {
            maxHeap(data, end);
            // 注意堆顶与最后一个叶子节点的交换
            // 将最大值一步一步放到最后
            int temp = data[0];
            data[0] = data[end];
            data[end] = temp;
        }
    }

    public static void maxHeap(int[] data, int end){

        int lastFather = (0 + end) % 2 != 0 ? (0 + end) / 2 : (0 + end) / 2 - 1;

        for (int father = lastFather; father >= 0; father--) {
            int left = father * 2 + 1;
            int right = father * 2 + 2;

            // right是小于等于end 因为end是数组长度减一 不会越界
            if (right <= end && data[right] > data[father]) {
                int temp = data[right];
                data[right] = data[father];
                data[father] = temp;
            }

            if (data[left] > data[father]) {
                int temp = data[left];
                data[left] = data[father];
                data[father] = temp;
            }
        }
    }


    /**
     * @author a5071
     * description 快速排序
     */
    public static void quick(int[] data, int left, int right){
        int temp = 0;
        int l = left;
        int r = right;
        int mid = data[(left + right) / 2];
        while (l < r) {
            while (data[l] < mid) {
                l++;
            }
            while (data[r] > mid) {
                r--;
            }
            if (l >= r) {
                break;
            }

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
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quick(data, left, r);
        }
        if (right > l) {
            quick(data, l, right);
        }
    }


    /**
     * @author a5071
     * description 希尔排序
     */
    public static void shell(int[] data){
        int temp = 0;
        int jmp = data.length / 2;

        while (jmp != 0) {
            for (int i = jmp; i < data.length; i++) {
                temp = data[i];
                int j = i - jmp;
                // 注意此处j>=0
                while (j >= 0 && temp < data[j]) {
                    data[j + jmp] = data[j];
                    j -= jmp;
                }
                // 同temp交换
                data[j + jmp] = temp;
            }
            // 退出while循环必不可少 多次折半最终排序完成
            jmp /= 2;
        }
    }


    /**
     * @author a5071
     * description 选择排序
     */
    public static void select(int[] data){

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }


    /**
     * @author a5071
     * description 插入排序
     */
    public static void insert(int[] data){

        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }


    /**
     * @author a5071
     * description 冒泡
     */
    public static void bubble(int[] data){
        int temp;

        for (int i = 0; i < data.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag++;
                }
            }
            if (flag == 0) break;
        }
    }


    /**
     * @author a5071
     * description 基数排序
     */


}
