package com.lzw.sort;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author a5071
 * @since 2021/11/29 16:05
 * description
 */
public class TotalSort{

    @Test
    public void testBubble(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");


        System.out.println("排序开始后：");
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
            System.out.println(Arrays.toString(data));
            System.out.println(" ");
        }

        System.out.println("");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }


    @Test
    public void testSelect(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
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
            System.out.println(Arrays.toString(data));
            System.out.println(" ");
        }

        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }


    @Test
    public void testInsert(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
            System.out.println(Arrays.toString(data));
            System.out.println(" ");
        }

        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }


    @Test
    public void testShell(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
        int jmp = data.length / 2;
        while (jmp != 0) {
            for (int i = jmp; i < data.length; i++) {
                int temp = data[i];
                int j = i - jmp;
                while (j >= 0 && temp < data[j]) {
                    data[j + jmp] = data[j];
                    j -= jmp;
                }
                data[j + jmp] = temp;

            }
            System.out.println(Arrays.toString(data));
            System.out.println(" ");

            jmp /= 2;
        }
        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }


    @Test
    public void testMerge(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        int[] temp = new int[data.length];
        System.out.println(Arrays.toString(data));
        System.out.println("\n");


        System.out.println("排序开始后：");
        merge(data, 0, data.length - 1, temp);

        System.out.println(Arrays.toString(data));
        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }

    public static void merge(int[] data, int left, int right, int[] temp){

        // left < right
        if (left < right) {
            int mid = (left + right) / 2;

            merge(data, left, mid, temp);

            merge(data, mid + 1, right, temp);

            mergeSort(data, left, mid, right, temp);
        }

    }

    public static void mergeSort(int[] data, int left, int mid, int right, int[] temp){

        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            // data[l] <= data[r]
            if (data[l] <= data[r]) {
                temp[t] = data[l];
                t++;
                l++;
            } else {
                temp[t] = data[r];
                t++;
                r++;
            }
        }

        while (l <= mid) {
            temp[t] = data[l];
            t++;
            l++;
        }

        while (r <= right) {
            temp[t] = data[r];
            t++;
            r++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            data[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }


    @Test
    public void testHeap(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
        heap(data);
        System.out.println(Arrays.toString(data));
        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }

    public static void heap(int[] data){

        for (int end = data.length - 1; end > 0; end--) {
            maxHeap(data, end);

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

            if (right <= end && data[right] > data[father]){
                int temp = data[right];
                data[right] = data[father];
                data[father] = temp;
            }

            if (data[left] > data[father]){
                int temp = data[left];
                data[left] = data[father];
                data[father] = temp;
            }
        }
    }


    @Test
    public void testQuick(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");

        System.out.println("排序开始后：");
        quick(data, 0, data.length- 1);
        System.out.println(Arrays.toString(data));

        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }

    public static void quick(int[] data, int left, int right){
        int l = left;
        int r = right;
        int mid = data[(left + right) / 2];

        while (l<r){

            while (data[l] < mid){
                l++;
            }
            while (data[r] > mid){
                r--;
            }

            if (l>=r) break;

            int temp = data[l];
            data[l] = data[r];
            data[r] = temp;

            if (data[l] == mid){
                r--;
            }
            if (data[r] == mid){
                l++;
            }

        }
        if (l == r) l++; r--;

        if (left < r) {
            quick(data, left, r);
        }

        if (right > l) {
            quick(data, l, right);
        }

    }


    @Test
    public void testRadix(){
        long start = System.currentTimeMillis();
        System.out.println("排序开始前：");
        int[] data = {2, 6, 4, 3, 8, 1, 9, 5, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("\n");


        System.out.println("排序开始后：");
        for (int n = 1; n < 10000000 ; n *= 10) {
            int[][] temp = new int[10][data.length];
            for (int i = 0; i < data.length; i++) {
                int m = (data[i] / n) % 10;
                temp[m][i] = data[i];
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (temp[i][j] != 0){
                        data[k] = temp[i][j];
                        k++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(data));

        System.out.println("\n");
        long end = System.currentTimeMillis();
        System.out.println("排序用时：" + (end - start));
    }
}
