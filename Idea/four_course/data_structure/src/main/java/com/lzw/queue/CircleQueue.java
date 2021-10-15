package com.lzw.queue;

import java.util.Scanner;

/**
 * @author: a5071
 * @date: 2021/9/14 16:01
 * @description: 优化版本 环形队列
 */
public class CircleQueue{
    public static void main(String[] args){

        // 创建初始队列
        CircleArray circleArray = new CircleArray(3);
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
            System.out.println("u：查看有效数据");
            System.out.println("----------------");

            key = scanner.next().charAt(0); // 接受一个字符
            switch (key){
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("头数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                case 'u':
                    int size = circleArray.size();
                    System.out.println("有效数据为"+size);
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray{
    private int maxSize; // 数组的最大容量
    private int front; // 队列头 指向队列第一个元素
    private int rear; // 队列尾 指向队列最后一个元素的后面 rear初始值为 0
    private int[] arr; // 存放数据 模拟队列


    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }


    // 判断队列是否满了
    public boolean isFull(){
        return (rear + 1)% maxSize == front;
    }


    // 队列为空
    public boolean isEmpty(){
        return rear == front;
    }


    // 添加数据到队列
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("队列满了，无法添加");
            return;
        }
        arr[rear] = n;
        // 将rear后移
        rear = (rear + 1)% maxSize;
    }


    // 获取队列的数据，出队列
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        // 分析front指向队列的第一个元素
        // 先把front保留一个临时变量中；把front后移；将临时变量返回

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }


    // 求出有效数据个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }


    // 显示队列的所有数据
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("无数据");
            return;
        }
        // 从front遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    // 显示队列头数据
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        return arr[front];
    }


}