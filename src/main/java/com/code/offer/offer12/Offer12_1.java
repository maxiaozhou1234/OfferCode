package com.code.offer.offer12;

import com.code.offer.Utils;

public class Offer12_1 {

    /*
     * 打印1到最大的n位数
     *
     * 使用全排列，递归思路
     */
    public static void main(String[] args) {

        Offer12_1 test = new Offer12_1();
        test.print1ToMaxNDigits(1);
        test.print1ToMaxNDigits(2);
        test.print1ToMaxNDigits(5);
    }

    private void print1ToMaxNDigits(int n) {
        System.out.println("input n: " + n);
        if (n <= 0) {
            System.out.println("input error >> " + n);
            return;
        }
        Utils.initTime();
        int[] number = new int[n];

        System.out.print(" |-- output >> ");
        for (int i = 0; i < 10; i++) {
            number[0] = i;
            print1ToMaxNDigitsRecursively(number, 0);
        }
        System.out.println();
        Utils.timeConsuming();
    }

    private void print1ToMaxNDigitsRecursively(int[] number, int index) {
        if (index == number.length - 1) {
            print(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = i;
            print1ToMaxNDigitsRecursively(number, index + 1);
        }
    }

    private StringBuilder sb = new StringBuilder();

    private void print(int[] number) {
        sb.setLength(0);
        boolean skip = true;
        for (int i = 0; i < number.length; i++) {

            if (skip && number[i] != 0) {
                skip = false;
            }
            if (!skip) {
                sb.append(number[i]);
            }
        }
        System.out.print(sb.toString() + ",");
    }

}
