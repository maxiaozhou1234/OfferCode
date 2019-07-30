package com.code.offer.offer3;

import com.code.offer.Utils;

public class Offer3 {

    /*
     * 二维数组中的查找
     *
     * 二维数组从左到右，从上到小都是递增序列
     * 判断输入数字是否在数组中
     */
    public static void main(String[] args) {
        Offer3 test = new Offer3();

        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };

        test.find(array, 3);
        test.find(array, 9);
        test.find(array, 7);

    }

    private void find(int[][] array, int target) {

        if (array == null) {
            System.out.println("input >> error");
            return;
        }
        System.out.println("input >> target=" + target);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        Utils.initTime();
        boolean result = false;
        int rows = array.length - 1;
        int column = array[0].length - 1;
        int row = 0;

        while (row < rows && column >= 0) {
            int tmp = array[row][column];
            if (tmp == target) {
                result = true;
                break;
            } else if (tmp > target) {
                column--;
            } else {
                row++;
            }
        }
        System.out.println(" |-- output >> " + (result ? "found " + target + " in row=" + row + " column=" + column : "no found"));
        Utils.timeConsuming();

    }
}
