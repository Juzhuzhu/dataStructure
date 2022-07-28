package com.juzhuzhu.sparsearray;

/**
 * 内容
 * <p>
 * Create at 2022/07/28 17:07
 *
 * @author 罗康明
 * @version 1.0.0, 2022/07/28
 * @since 1.0.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘原始数组11*11，0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        /*----------------------------原始数组转换成稀疏数组-----------------------------*/
        int sum = 0;
        //统计原始数组中非0的个数
        for (int[] ints : chessArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组第一行赋值记录原始数组有多少行多少列多少个非0的数字
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;
        //从稀疏数组第二列开始记录原始数组的非0值
        int sparseRow = 1;
        //遍历原始数组,将非0值记录到稀疏数组中
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[sparseRow][0] = i;
                    sparseArray[sparseRow][1] = j;
                    sparseArray[sparseRow][2] = chessArray[i][j];
                    sparseRow++;
                }
            }
        }

        /*----------------------------稀疏数组转换成原始数组-----------------------------*/
        int arrRow = sparseArray[0][0];
        int arrCol = sparseArray[0][1];
        int[][] newArray = new int[arrRow][arrCol];
        //从第二行开始读取稀疏数组，给原始数组对应位置赋值
        for (int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            newArray[row][col] = sparseArray[i][2];
        }
    }
}
