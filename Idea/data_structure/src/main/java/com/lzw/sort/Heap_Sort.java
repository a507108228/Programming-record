package com.lzw.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author a5071
 * @since 2021/11/25 19:55
 * description 堆排序
 * 最大堆积树：节点元素比两子元素大
 * 最小堆积树：节点元素总是比子元素小
 */
public class Heap_Sort{

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        SimpleDateFormat time01 = new SimpleDateFormat("yyyy:MM:dd--HH:mm:ss:SSSS");
        System.out.println("开始时间：" + time01.format(new Date()));

        int[] data = new int[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 80000);
        }
        System.out.println("堆排序前" + Arrays.toString(data));

        heapSort(data);

        System.out.println("堆排序后" + Arrays.toString(data));
        System.out.println(" ");
        SimpleDateFormat time02 = new SimpleDateFormat("yyyy:MM:dd--HH:mm:ss:SSSS");
        System.out.println("结束时间：" + time02.format(new Date()));
        long end = System.currentTimeMillis();
        System.out.println("堆排序用时：" + (end - start) + " ms");
    }


    public static void heapSort(int[] data){
        // end = data.length - 1 所有元素均参与了
        // end-- 逐步找到堆顶
        // end>0 就是倒数第二个元素 最后一个元素没必要比较了
        for (int end = data.length - 1; end > 0; end--) {
            // 调整成最大堆积树
            maxHeap(data, end);

            // 堆顶元素(此时树里最大的元素)和最后一个叶子元素交换
            // 堆顶元素就是下标为0的那个
            // end是参与堆排序的数组最大下标
            int temp = data[0];
            data[0] = data[end];
            data[end] = temp;

        }
    }

    /**
     * @author a5071
     * description 调整最大堆积树
     */
    public static void maxHeap(int[] data, int end){
        // 最后一个父节点的下标
        int lastFather = (0 + end) % 2 != 0 ? (0 + end) / 2 : (0 + end) / 2 - 1;

        for (int father = lastFather; father >= 0; father--) {
            // 左孩子 2n+1 右孩子 2n+2
            int left = father * 2 + 1;
            int right = father * 2 + 2;

            // 右孩子不能越界 且比较 大的交换当节点
            if (right <= end && data[right] > data[father]) {
                int temp = data[right];
                data[right] = data[father];
                data[father] = temp;
            }
            // 左边比较父节点
            if (data[left] > data[father]) {
                int temp = data[left];
                data[left] = data[father];
                data[father] = temp;
            }

        }
    }




}
