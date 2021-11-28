package com.lzw.sort.question;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author a5071
 * @since 2021/11/27 14:35
 * description 已知序列 插入、选择、希尔、冒泡排序
 */
public class Part_02{

    public static void main(String[] args){
        int[] data = new int[]{29, 75, 17, 90, 111, 13};

        // testBubble(data);
        // testSelect(data);
        // testInsert(data);
        // testShell(data);
        testQuick(data, 0, data.length - 1);
        // testHeap(data);
        // testRadix(data);

    }


    public static void testBubble(int[] data){

        for (int i = 0; i < data.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag++;
                }
            }
            if (flag == 0) break;
            System.out.println("每次交换如下：" + Arrays.toString(data));
        }
    }

    public static void testSelect(int[] data){
        for (int i = 0; i < data.length - 1; i++) {
            int flag = 0;
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    flag++;
                }
            }
            if (flag == 0) break;
            System.out.println("每次遍历如下：" + Arrays.toString(data));
        }
    }

    public static void testInsert(int[] data){
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
            System.out.println("每次遍历如下：" + Arrays.toString(data));
        }
    }

    public static void testShell(int[] data){
        int temp;
        int jmp = data.length / 2;
        while (jmp != 0) {
            for (int i = jmp; i < data.length; i++) {
                temp = data[i];
                int j = i - jmp;
                while (j >= 0 && temp < data[j]) {
                    data[j + jmp] = data[j];
                    j -= jmp;
                }
                data[j + jmp] = temp;
                System.out.println("每次遍历如下：" + Arrays.toString(data));
            }
            jmp /= 2;
        }
    }

    public static void testQuick(int[] data, int left, int right){
        int temp;
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
            if (l >= r) break;

            temp = data[l];
            data[l] = data[r];
            data[r] = temp;

            if (data[l] == mid) r--;
            if (data[r] == mid) l++;

            System.out.println(Arrays.toString(data));
        }
        if (l == r) l++;
        r--;

        if (left < r) testQuick(data, left, r);
        if (right > l) testQuick(data, l, right);
    }

    public static void testHeap(int[] data){

        for (int end = data.length - 1; end > 0; end--) {
            testMaxHeap(data, end);

            int temp = data[0];
            data[0] = data[end];
            data[end] = temp;
            System.out.println(Arrays.toString(data));
        }
    }

    public static void testMaxHeap(int[] data, int end){

        int lastFather = (0 + end) % 2 != 0 ? (0 + end) / 2 : (0 + end) / 2 - 1;

        for (int father = lastFather; father >= 0; father--) {
            int left = father * 2 + 1;
            int right = father * 2 + 2;

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

    public static void testRadix(int[] data){

        for (int n = 1; n <= 100; n *= 10) {
            int[][] temp = new int[10][data.length];
            for (int i = 0; i < data.length; i++) {
                int m = (data[i] / n) % 10;
                temp[m][i] = data[i];
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (temp[i][j] != 0) {
                        data[k] = temp[i][j];
                        k++;
                    }
                }
            }
            System.out.println(Arrays.toString(data));
        }
    }


    /**
     * @author a5071
     * @description
     */
    @Test
    public void test(){


    }
}
