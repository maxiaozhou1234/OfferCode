package com.code.offer.offer41;

import com.code.offer.Utils;

public class Offer41 {

    /*
    * 和为s的两个数字（前提是递增数组）
    * 和为s的连续序列
     */
    public static void main(String[] main) {
        Offer41 test = new Offer41();

        int[] array = new int[]{1, 2, 5, 6, 8, 10, 14};
        System.out.println("和为s的两个数字");
        Utils.initTime();
        test.findNumberWithSum(array, 2);
        test.findNumberWithSum(array, 3);
        test.findNumberWithSum(array, 14);
        test.findNumberWithSum(array, 20);
        Utils.timeConsuming();

        System.out.println("和为s的连续序列");
        Utils.initTime();
        test.findSumSequence(3);
        test.findSumSequence(6);
        test.findSumSequence(8);
        test.findSumSequence(15);
        Utils.timeConsuming();

    }

    private void findNumberWithSum(int[] array, int sum) {

        if (Utils.checkEmptyArray(array)) {
            int start = 0, end = array.length - 1;
            boolean found = false;
            while (start < end) {
                int tmp = array[start] + array[end];
                if (tmp == sum) {
                    found = true;
                    break;
                } else if (tmp > sum) {
                    end--;
                } else {
                    start++;
                }
            }
            System.out.println(" |-- output >> target=" + sum + " -- " + (found ? (array[start] + "," + array[end]) : "not found"));
        }
    }

    private void findSumSequence(int sum) {

        System.out.println("input >> target = " + sum);
        if (sum < 3) {
            System.out.println(" |-- sum is smallest.");
            return;
        }
        int small = 1, big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {//最小的数超出中位数，那么最小与后面任意一个相加都大于总数
            if (curSum == sum) {
                printSequence(small, big);
            }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    printSequence(small, big);
                }
            }

            big++;
            curSum += big;
        }
    }

    private void printSequence(int start, int end) {
        System.out.print(" |-- output >> ");
        for (int i = start; i < end; i++) {
            System.out.print(i + ",");
        }
        System.out.println(end);
    }
}
