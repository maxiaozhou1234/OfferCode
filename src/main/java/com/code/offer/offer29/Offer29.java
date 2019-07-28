package com.code.offer.offer29;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer29 {

    /*
    * 数组中超过一半的数字
     */
    public static void main(String[] args) {
        Offer29 test = new Offer29();

        test.findMoreThanHalf(new int[]{1, 2, 3, 2});
        test.findMoreThanHalf(new int[]{1, 2, 3, 2, 2});
        test.findMoreThanHalf(new int[]{1, 2, 3, 6, 5, 4});
        test.findMoreThanHalf(new int[]{1, 3, 2, 4, 2, 5, 6, 2, 2, 2, 2});

        test.findMoreThanHalf2(new int[]{1, 2, 3, 2});
        test.findMoreThanHalf2(new int[]{1, 2, 3, 2, 2});
        test.findMoreThanHalf2(new int[]{1, 2, 3, 6, 5, 4});
        test.findMoreThanHalf2(new int[]{1, 3, 2, 4, 2, 5, 2, 6, 2, 2, 2});
    }

    //使用快排思路
    private void findMoreThanHalf(int[] array) {
        System.out.println("input >> " + Arrays.toString(array) + " length = " + (array == null ? 0 : array.length));
        if (array == null || array.length == 0) {
            System.out.println(" |-- input error");
            return;
        }
        Utils.initTime();
        int start = 0, end = array.length - 1;
        int middle = (array.length - 1) / 2;

        int index = partition(array, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(array, start, end);
            } else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }
        int result = array[middle];
        int count = 0;
        for (int i : array) {
            if (i == result) {
                count++;
            }
        }
        if (count * 2 > array.length) {
            System.out.println(" |-- output >> " + result);
        } else {
            System.out.println(" |-- output >> not found more than half number.");
        }
        Utils.timeConsuming();
    }

    private int partition(int[] array, int start, int end) {

        if (start < 0 || end >= array.length) {
            throw new IllegalArgumentException("start/end is illegal");
        }

        int middle = end / 2 + start / 2;
        int tmp = array[middle];
        array[middle] = array[end];
        array[end] = tmp;

        int index = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] <= array[end]) {
                index++;
                if (index != i) {
                    int t = array[i];
                    array[i] = array[index];
                    array[index] = t;
                }
            }
        }
        index++;
        int t = array[index];
        array[index] = array[end];
        array[end] = t;

        return index;
    }

    //利用数组，如果相同数加一，不同减一，如果为0，重新赋值，最后再检查是否超过一半
    private void findMoreThanHalf2(int[] array) {
        System.out.println("input >> " + Arrays.toString(array) + " length = " + (array == null ? 0 : array.length));
        if (array == null || array.length == 0) {
            System.out.println(" |-- input error");
            return;
        }
        int result = array[0];
        int time = 1;
        Utils.initTime();
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                result = array[i];
                time = 1;
            } else if (array[i] == result) {
                time++;
            } else {
                time--;
            }
        }

        int count = 0;
        for (int i : array) {
            if (i == result) {
                count++;
            }
        }
        if (count * 2 > array.length) {
            System.out.println(" |-- output >> " + result);
        } else {
            System.out.println(" |-- output >> not found more than half number.");
        }

        Utils.timeConsuming();
    }
}
