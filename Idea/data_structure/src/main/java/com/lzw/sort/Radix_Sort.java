package com.lzw.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author a5071
 * @since 2021/11/26 15:03
 * description 基数排序 稳定排序法
 * 空间复杂度：需要很大的额外的空间O(n*p)
 * 时间复杂度：O(nlog p k)
 */
public class Radix_Sort{

    @Test
    public void testRadix(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss:SSSS");
        System.out.println("开始时间：" + format1.format(new Date()));
        long start = System.currentTimeMillis();
        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 40000);
        }
        System.out.println("基数排序前：" + Arrays.toString(data));
        System.out.println(" ");

        // radixSort(data);

        radixTest(data);

        System.out.println(" ");
        System.out.println("基数排序后：" + Arrays.toString(data));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss:SSSS");
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
            System.out.println("排序结果" + Arrays.toString(data));
        }
    }

    public static void radixTest(int[] data){

        for (int n = 1; n <= 100000000; n *= 10) {
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
            System.out.println("每次排序结果为："+Arrays.toString(data));
        }
    }
}
