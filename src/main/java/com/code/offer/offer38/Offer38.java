package com.code.offer.offer38;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer38 {

    /*
     * 数字在排序数组出现的次数
     *
     * 输入 {1,2,3,3,3,3,4,5}
     * 3 -> 4
     * */
    public static void main(String[] args) {
        Offer38 test = new Offer38();
        test.queryCount(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 0);
        test.queryCount(new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5, 5}, 3);
        test.queryCount(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 5);
        test.queryCount(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3);
    }

    private void queryCount(int[] array, int target) {

        if (array == null || array.length == 0) {
            System.out.println("empty array");
            return;
        }

        System.out.println("input >> " + Arrays.toString(array) + " >> " + target);
        Utils.initTime();
        int start = getFirstIndex(array, target, 0, array.length - 1);
        int end = getLastIndex(array, target, 0, array.length - 1);

        if (start > -1 && end > -1) {
            int count = end - start + 1;
            System.out.println(" |-- start:" + start + " end:" + end);
            System.out.println(" |-- out >> target:" + target + " count> " + count);
        } else {
            System.out.println(" |-- doest not exit >> target:" + target);
        }
        Utils.timeConsuming();

    }

    private int getFirstIndex(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (end + start) / 2;//start+(end-start)/2
        if (array[middle] == k) {
            if (middle - 1 > 0 && array[middle - 1] != k || middle == 0) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (array[middle] < k) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }

        return getFirstIndex(array, k, start, end);
    }

    private int getLastIndex(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (end + start) / 2;
        //{1,2,3,3,3,3,4,5}
        if (array[middle] == k) {
            if (middle + 1 < array.length && array[middle + 1] != k || middle == array.length - 1) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (array[middle] < k) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }
        return getLastIndex(array, k, start, end);
    }


}
