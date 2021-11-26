package com.lzw.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;

import java.util.*;

/**
 * @author a5071
 * @since 2021/11/25 16:16
 * description 冒泡 选择 插入 希尔 快速排序
 */
public class BSISQ_Sort{


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

        int[] data = new int[50000000];
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

        if (l == r) l++; r--;

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
        final int count = 50000;
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

        if (l == r) l++; r--;

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
    public void test(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        System.out.println("堆排序前：" + Arrays.toString(data));
        System.out.println(" ");



        System.out.println("堆排序后：" + Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("结束时间：" + format2.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("堆排序花费时间为：" + (end - start) + " ms");
    }



}
