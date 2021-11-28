package com.lzw.demo_01;

import com.lzw.utils.NumInputException;

import java.util.Scanner;

/**
 * @author a5071
 * @since 2021/11/11 10:25
 * description: 自定义异常并且键盘录入
 */
public class Demo_01{

    public static void main(String[] args) throws NumInputException{
        System.out.println("请输入1--3之间任一数字：");
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNext("0")) {
            int i = scan.nextInt();
            switch (i) {
                case 1:
                    System.out.println("课程一");
                    break;

                case 2:
                    System.out.println("课程二");
                    break;

                case 3:
                    System.out.println("课程三");
                    break;

                default:
                    System.out.println("无效字符");
                    try{
                        int il = i/0;
                    }catch (Exception e){
                        throw new NumInputException("计算有误");
                    }

            }
            System.out.println("------欢迎提出建议");
        }
        scan.close();
    }

}
