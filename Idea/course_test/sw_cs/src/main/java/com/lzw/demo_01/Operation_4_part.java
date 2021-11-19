package com.lzw.demo_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

//代码2.2
/* 分解成4个部分：
（1）增加一个程序头打印函数void printHeader()，比如简单说明本程序的作用和使用。
（2）函数void generateEquations()，产生加法或减法算式的符号串并存入一个数组。
（3）输出习题的函数void printExercise()，它接收generateEquations的输出，按
         照要求打印输出所有的算式。
（4）输出习题中每个算式的计算结果void printCalculations()。
 */
public class Operation_4_part{
    static String[] e = new String[50];//存储算式（不带结果）
    static short[] r = new short[50];//存储计算结果

    public static void printHeader(){
        System.out.println("--------------------------------------");
        System.out.println("- 程序输出50道100以内的加法减法算式的习题 -");
        System.out.println("- 每次运行程序可得到一套50道题的习题及答案 -");
        System.out.println("--------------------------------------");
    }

    public static void generateEquations(){
        short m = 0, n = 0, v = 0, ov = 0; //定义m:左操作数，n：右操作数，v:计算结果，ov: 运算符数字
        char o = '+'; //运算符
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            ov = (short) random.nextInt(2);
            m = (short) random.nextInt(101);        // 随机产生运算数
            if (ov == 1) {
                do {
                    n = (short) random.nextInt(101);
                    v = (short) (m + n);
                } while (100 < v || v < 0);    //若算式结果大于100或小于0，重新计算
                o = '+';
            } else {
                do {
                    n = (short) random.nextInt(101);
                    v = (short) (m - n);
                } while (100 < v || v < 0);
                o = '-';
            }
            e[i] = "" + m + o + n + "=";
            r[i] = v;
        }
    }

    public static void printExercise(){
        for (int i = 0; i < e.length; i++) {
            System.out.print(" " + (i + 1) + "：" + e[i] + "\t");
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }

    public static void printCalculations(){
        for (int i = 0; i < r.length; i++) {
            System.out.print("" + (i + 1) + "：" + r[i] + "\t");
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        File file = new File("M:\\Git\\test\\算式.txt");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(fos);
        System.setOut(printStream);  // 将文件输出到指定目录
        printHeader();           //打印头函数
        generateEquations();     //生成算式和答案，并存入数组
        printExercise();         //打印算式
        System.out.println("---------------------------");
        System.out.println("- 下面是习题的参考答案    ");
        printCalculations();     //打印答案
        fos.close();

    }
}

