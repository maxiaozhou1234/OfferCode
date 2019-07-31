package com.code.offer.offer20;

public class Offer20 {

    /*
     * 顺时针打印矩阵
     */
    public static void main(String[] args) {
        Offer20 test = new Offer20();

        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        test.printMatrix(array);

        System.out.println();
        test.printMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        });
        System.out.println();
        test.printMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        });
    }

    private void printMatrix(int[][] array) {

        if (array == null) {
            System.out.println("input null");
            return;
        }

        int start = 0;
        int row = array.length;
        int column = array[0].length;
        while (row > start * 2 && column > start * 2) {
            printMatrixInCircle(array, row, column, start);
            start++;
        }
    }

    private void printMatrixInCircle(int[][] array, int row, int column, int start) {

        int endX = column - start - 1;
        int endY = row - start - 1;

        for (int i = start; i <= endX; i++) {
            int a = array[start][i];
            System.out.print(a + " ");
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int a = array[i][endX];
                System.out.print(a + " ");
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int a = array[endY][i];
                System.out.print(a + " ");
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                int a = array[i][start];
                System.out.print(a + " ");
            }
        }
    }
}
