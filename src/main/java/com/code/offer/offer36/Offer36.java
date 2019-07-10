package com.code.offer.offer36;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer36 {

    /*
    * 数组中的逆序对
    *
    * 在数组中的两个数字如果前一个数字大于后面的数字，则这两个数字组成一个逆序对
    *
    * 输入 {7,5,6,4}
    * (7,6) (7,5) (7,4) (6,4) (5,4)
    *
    * 1、遍历，每个数字向后比，复杂度 O(n^2)
    * 2、类归并法
    *
    * */
    public static void main(String[] args) {

        Offer36 test = new Offer36();
        test.inversePairs(new int[]{2, 1});
        test.inversePairs(new int[]{3, 4});
        test.inversePairs(new int[]{2, 1, 3, 5});
        test.inversePairs(new int[]{7, 5, 6, 4});
        test.inversePairs(new int[]{7, 5, 6, 1, 4});
        test.inversePairs(new int[]{7, 5, 9, 6, 1, 4});
    }

    private void inversePairs(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("empty array.");
            return;
        }

        System.out.println("input >> " + Arrays.toString(data));

        Utils.initTime();
        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }
        int count = inversePairsCode(data, copy, 0, data.length - 1);
        System.out.println(" |-- out >> count:" + count);
        System.out.println(" |-- data" + Arrays.toString(data));
        System.out.println(" |-- copy" + Arrays.toString(copy));
        Utils.timeConsuming();

    }

    private int inversePairsCode(int[] data, int[] copy, int start, int end) {

        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int len = (end - start) / 2;
        int left = inversePairsCode(copy, data, start, start + len);
        int right = inversePairsCode(copy, data, start + len + 1, end);
        int count = 0;
        int i = start + len;
        int j = end;
        int curIndex = end;

        while (i >= start && j >= start + len + 1) {
            if (data[i] > data[j]) {
                copy[curIndex--] = data[i--];
                count += j - start - len;
            } else {
                copy[curIndex--] = data[j--];
            }
        }

        for (; i >= start; i--) {
            copy[curIndex--] = data[i];
        }

        for (; j >= start + len + 1; j--) {
            copy[curIndex--] = data[j];
        }

        return left + right + count;
    }
}
