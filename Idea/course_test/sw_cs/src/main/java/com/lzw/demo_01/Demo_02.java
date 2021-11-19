package com.lzw.demo_01;

import java.util.Scanner;

/**
 * @author a5071
 * @since 2021/11/11 17:34
 * description: 自定义异常并且键盘录入
 */
public class Demo_02{


    public static void main(String[] args){
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int number = scanner.nextInt();
        try {
            if (number == 1) {
                System.out.println("课程设计");
            } else if (number == 2) {
                System.out.println("计算机网络");
            } else if (number == 3) {
                System.out.println("数据结构");
            } else
                throw new NumInputException();
        } catch (NumInputException num) {
            // TODO: handle exception
            num.printStackTrace();
        } finally {
            System.out.println("欢迎提出建议!");
        }
    }

}


class NumInputException extends Exception{
    @Override
    public void printStackTrace(){
        // TODO Auto-generated method stub
        System.out.println("请输入1 or 2 or 3 ");
    }
}

