package com.lzw.queue;

import java.util.Scanner;

/**
 * @author: a5071
 * @date: 2021/9/14 15:04
 * @description: 数组模拟队列
 */
public class ArrayQueue{
    public static void main(String[] args){
        // 创建初始队列
        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while ( loop ){
            System.out.println("s：显示队列");
            System.out.println("e：退出队列");
            System.out.println("a：添加队列");
            System.out.println("g：取出队列");
            System.out.println("h：查看头部队列");
            System.out.println("----------------");
            System.out.println("----------------");

            key = scanner.next().charAt(0); // 接受一个字符
            switch (key){
                case 's':
                    arrayQueueDemo.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueueDemo.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueueDemo.getQueue();
                        System.out.printf("取出的数据%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueueDemo.headQueue();
                        System.out.printf("头数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;

                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueueDemo {
    private int maxSize; // 数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 存放数据 模拟队列

    // 创建队列的构造器
    public ArrayQueueDemo(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部，队列头的前一个位置
        rear = -1; // 指向队列最后一个数据

    }

    // 判断队列是否满了
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    // 队列为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        if ( isFull() ){
            System.out.println("队列满了，无法添加");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据，出队列
    public int getQueue(){
        if( isEmpty() ){
            throw new RuntimeException("队列为空，无法取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue(){
        if ( isEmpty() ){
            System.out.println("无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    // 显示队列头数据
    public int headQueue(){
        if ( isEmpty() ){
            throw new RuntimeException("队列为空，无法取数据");
        }
        return arr[front+1];
    }


}