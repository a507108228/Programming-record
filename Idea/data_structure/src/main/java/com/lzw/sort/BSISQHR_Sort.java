package com.lzw.sort;


import org.junit.Test;

import java.text.SimpleDateFormat;

import java.util.*;

/**
 * @author a5071
 * @since 2021/11/25 16:16
 * description 冒泡 选择 插入 希尔 快速 堆 基数 归并排序
 */
public class BSISQHR_Sort{


    /**
     * @author a5071
     * @description 冒泡排序
     */
    @Test
    public void testBubble(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int i, j, temp, flag;
        int[] data = new int[500000];
        for (i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        // System.out.println("冒泡排序前："+Arrays.toString(data));

        System.out.println(" ");
        for (i = 0; i < data.length - 1; i++) {
            flag = 0;
            for (j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag++;
                }
            }
            // 等于零意味着没有发生交换了
            if (flag == 0) break;
        }
        // System.out.println("冒泡排序后："+Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("冒泡排序花费时间为：" + (end - start) + " ms");
    }


    /**
     * @author a5071
     * @description 选择排序
     */
    @Test
    public void testSelect(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int i, j, temp;
        int[] data = new int[500000];
        for (i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        // System.out.println("选择排序前：" + Arrays.toString(data));

        System.out.println(" ");
        // i从 0 开始 j从 1 开始
        for (i = 0; i < data.length - 1; i++) {
            for (j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        // System.out.println("选择排序后：" + Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("选择排序花费时间为：" + (end - start) + " ms");
    }


    /**
     * @author a5071
     * @description 插入排序
     */
    @Test
    public void testInsert(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int i, j, temp;
        int[] data = new int[500000];
        for (i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        // System.out.println("插入排序前：" + Arrays.toString(data));

        System.out.println(" ");
        for (i = 1; i < data.length; i++) {
            temp = data[i];
            j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = temp;
        }
        // System.out.println("插入排序后：" + Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("插入排序花费时间为：" + (end - start) + " ms");
    }


    /**
     * @author a5071
     * @description 希尔排序
     */
    @Test
    public void testShell(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int i, j, temp;
        int[] data = new int[500000];
        int jmp = data.length / 2;
        for (i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        // System.out.println("希尔排序前：" + Arrays.toString(data));

        System.out.println(" ");
        while (jmp != 0) {
            for (i = jmp; i < data.length; i++) {
                temp = data[i];
                j = i - jmp;
                while (j >= 0 && temp < data[j]) {
                    data[j + jmp] = data[j];
                    j -= jmp;
                }
                data[j + jmp] = temp;
            }
            jmp /= 2;
        }
        // System.out.println("希尔排序后：" + Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("希尔排序花费时间为：" + (end - start) + " ms");
    }


    /**
     * @author a5071
     * @description 快速排序
     */
    @Test
    public void testQuick(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();

        int[] data = new int[500000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 80000);
        }
        // System.out.println("快速排序前：" + Arrays.toString(data));

        System.out.println("");
        arrQuick(data, 0, data.length - 1);

        // System.out.println("快速排序后：" + Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("快速排序花费时间为：" + (end - start) + " ms");
    }

    public static void arrQuick(int[] data, int left, int right){
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

        }

        if (l == r) l++;
        r--;

        if (left < r) arrQuick(data, left, r);
        if (right > l) arrQuick(data, l, right);

    }


    /**
     * @author a5071
     * @description list集合快排
     */
    @Test
    public void testLinkedListQuick(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        final int count = 500000;
        LinkedList<Integer> list = new LinkedList();

        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * 80000));
        }
        System.out.println(" ");
        // System.out.println("排序前：" + list);

        listQuick(list, 0, list.size() - 1);

        System.out.println(" ");
        // System.out.println("排序后：" + list);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("链表快排花费时间为：" + (end - start) + " ms");
    }

    public static void listQuick(LinkedList<Integer> list, int left, int right){
        int temp = 0;
        int l = left;
        int r = right;
        int mid = list.get((left + right) / 2);

        while (l < r) {
            while (list.get(l) < mid) {
                l++;
            }
            while (list.get(r) > mid) {
                r--;
            }
            if (l >= r) break;

            // *** 注意list交换
            temp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, temp);

            if (list.get(l) == mid) r--;
            if (list.get(r) == mid) l++;
        }

        if (l == r) l++;
        r--;

        // *** 注意此处  传入的值比r小意味着还需要排序
        if (left < r) listQuick(list, left, r);

        // 传入的值比l大意味着还需要排序
        if (right > l) listQuick(list, l, right);

    }


    /**
     * @author a5071
     * @description 堆排序
     */
    @Test
    public void testHeap(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss:SSSS");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        System.out.println("堆排序前：" + Arrays.toString(data));
        System.out.println(" ");

        heap(data);

        System.out.println("堆排序后：" + Arrays.toString(data));
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss:SSSS");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("堆排序花费时间为：" + (end - start) + " ms");
    }

    public static void heap(int[] data){

        // 所有元素参与比较 从末尾开始 比较简单
        for (int end = data.length - 1; end > 0; end--) {
            // 建立最大堆积树
            maxHeap(data, end);
            // 同堆顶元素比较
            int temp = data[0];
            data[0] = data[end];
            data[end] = temp;
        }
    }

    public static void maxHeap(int[] data, int end){

        // 最后一个找父节点 推断出其子节点 进行大小比较
        int lastFather = (0 + end) % 2 != 0 ? (0 + end) / 2 : (0 + end) / 2 - 1;

        // 循环找下一个父节点 比较 直到变成完全最大堆积树
        for (int father = lastFather; father >= 0; father--) {
            int left = 2 * father + 1;
            int right = 2 * father + 2;

            // 右叶子数组下标不能越界 当大于父节点时交换
            if (right <= end && data[right] > data[father]) {
                int temp = data[right];
                data[right] = data[father];
                data[father] = temp;
            }
            // 不用考虑越界情况 大于父节点发生交换
            if (data[left] > data[father]) {
                int temp = data[left];
                data[left] = data[father];
                data[father] = temp;
            }
        }
    }


    /**
     * @author a5071
     * description 基数排序
     */
    @Test
    public void test(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss---SSSS");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        System.out.println("排序前：" + Arrays.toString(data));
        System.out.println(" ");

        radixSort(data);

        System.out.println(" ");
        System.out.println("排序后：" + Arrays.toString(data));
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss---SSSS");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("花费时间为：" + (end - start) + " ms");
    }

    public static void radixSort(int[] data){

        for (int n = 1; n <= 100000000; n *= 10) {
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
     * description 归并排序
     */
    @Test
    public void testMerge(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss---SSSS");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        // 空数组
        int[] temp = new int[data.length];
        System.out.println("归并排序前：" + Arrays.toString(data));
        System.out.println(" ");

        merge(data, 0, data.length - 1, temp);

        System.out.println(" ");
        System.out.println("归并排序后：" + Arrays.toString(data));
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss---SSSS");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("归并花费时间为：" + (end - start) + " ms");
    }

    public static void merge(int[] data, int left, int right, int[] temp){
        if (left < right){
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
            if (data[l] < data[r]) {
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
        int temLeft = left;
        while (temLeft <= right){
            data[temLeft] = temp[t];
            t++;
            temLeft++;
        }

    }
}
