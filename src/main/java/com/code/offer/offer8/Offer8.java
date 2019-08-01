package com.code.offer.offer8;

import com.code.offer.Utils;

public class Offer8 {

    /*
     * 旋转数组最小数字
     *
     * 如输入：{3,4,5,1,2} 为 {1,2,3,4,5} 的旋转数组
     * 输出：最小数字是 1
     */
    public static void main(String[] args) {

        Offer8 test = new Offer8();

        int num = test.min(new int[]{3, 4, 5, 1, 2});
        System.out.println(" |-- output >> " + num);

        num = test.min(new int[]{1, 1, 1, 0, 1, 1, 1});
        System.out.println(" |-- output >> " + num);

        num = test.min(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(" |-- output >> " + num);

        num = test.min(new int[]{4, 5, 6, 7, 1, 2, 3, 4});
        System.out.println(" |-- output >> " + num);
    }

    private int min(int[] array) {

        if (Utils.checkEmptyArray(array)) {

            int start = 0, end = array.length - 1;
            int middle = start;

            while (array[start] >= array[end]) {

                if (end - start == 1) {
                    middle = end;
                    break;
                }

                middle = (end + start) / 2;

                if (array[start] == array[end] && array[start] == array[middle]) {
                    return minOrder(array, start, end);
                }

                if (array[start] <= array[middle]) {
                    start = middle;
                } else if (array[end] >= array[middle]) {
                    end = middle;
                }
            }

            return array[middle];
        } else {
            return -1;
        }
    }

    private int minOrder(int[] array, int start, int end) {

        int min = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
