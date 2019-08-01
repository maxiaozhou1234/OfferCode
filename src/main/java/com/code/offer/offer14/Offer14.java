package com.code.offer.offer14;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer14 {

    /*
     * 调整数组位置使奇数位于偶数前
     */
    public static void main(String[] args) {

        Offer14 test = new Offer14();
        test.reorder(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        test.reorder(new int[]{});
        test.reorder(new int[]{1});
        test.reorder(new int[]{1, 3});
        test.reorder(new int[]{4, 1});
        test.reorder(new int[]{1, 3, 5, 2, 5, 4, 9, 7, 8, 13, 12});

        //扩展写法，java7不支持函数传递，用接口，8以上使用lambda
        //负数在前，正数在后
        test.reorder(new int[]{1, -3, 5, -2, 5, 4, -9, 7, 8, -13, -12}, (a) -> a < 0);
    }

    private void reorder(int[] array) {

        if (Utils.checkEmptyArray(array)) {
            Utils.initTime();
            int start = 0, end = array.length - 1;
            while (start < end) {

                while (start < end && (array[start] & 0x1) == 1) {
                    start++;
                }

                while (start < end && (array[end] & 0x1) == 0) {
                    end--;
                }


                if (start < end) {
                    int t = array[end];
                    array[end] = array[start];
                    array[start] = t;
                }
            }
            System.out.println(" |-- output >> " + Arrays.toString(array));
            Utils.timeConsuming();
        }
    }

    private void reorder(int[] array, Condition func) {

        if (Utils.checkEmptyArray(array)) {
            Utils.initTime();
            int start = 0, end = array.length - 1;
            while (start < end) {

                while (start < end && func.condition(array[start])) {
                    start++;
                }

                while (start < end && !func.condition(array[end])) {
                    end--;
                }


                if (start < end) {
                    int t = array[end];
                    array[end] = array[start];
                    array[start] = t;
                }
            }
            System.out.println(" |-- output >> " + Arrays.toString(array));
            Utils.timeConsuming();
        }
    }

    @FunctionalInterface
    interface Condition {
        boolean condition(int a);
    }
}
