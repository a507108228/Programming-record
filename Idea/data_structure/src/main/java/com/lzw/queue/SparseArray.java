package com.lzw.queue;


/**
 * @author: a5071
 * @date: 2021/9/13 16:43
 * @description: 稀疏数组互相转化
 */
public class SparseArray{
    public static void main(String[] args){
        // 创建初始的二维数组

        // 0.无棋子 1.黑子 2.蓝子
        int[][] chessArr1 = new int[15][15];
        chessArr1[2][5] = 1;
        chessArr1[3][4] = 1;
        chessArr1[4][6] = 2;

        for (int[] row :
                chessArr1) {
            for (int data :
                    row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


        // 二维转稀疏数组
        // 先遍历二维数组得到非零的个数
        int sum = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效个数为：" + sum);


        // 创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 15;
        sparseArr[0][1] = 15;
        sparseArr[0][2] = sum;

        // 遍历二维数组 存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 10-14 shabi
        // 输出稀疏数组的形式

        System.out.println();
        System.out.println("稀疏数组为---");

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);

        }

        System.out.println();


        /**
         * @author: a5071
         * @description: 稀疏转二维
         */
        // 根据稀疏的第一行获取二维数组的行列
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 告诉二维数组 你的有效值的位置以及数值
        // 注意此处i = 1 因为第0行 保存的是行列 有效值三个属性
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        System.out.println("二维转稀疏---");
        for (int[] row :
                chessArr2) {
            for (int data :
                    row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
