package com.code.offer.offer12;

import com.code.offer.Utils;

public class Offer12 {

    /*
     * 打印1到最大的n位数
     *
     * 直接遍历输出遇到多位数有可能溢出，使用字符串打印
     *
     * 用字符串模拟数字加法
     */
    public static void main(String[] args) {
        Offer12 test = new Offer12();

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
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }

        System.out.print(" |-- output >> ");
        while (!increment(number)) {
            print(number);
        }
        System.out.println();
        Utils.timeConsuming();

    }

    private boolean increment(char[] number) {

        boolean isOverflow = false;

        int takeOver = 0;//进位
        int length = number.length - 1;
        for (int i = length; i >= 0; i--) {

            int num = number[i] - '0' + takeOver;
            if (i == length) {
                num++;
            }

            if (num >= 10) {
                if (i == 0) {
                    isOverflow = true;
                }
                takeOver = 1;
                number[i] = (char) ('0' + num - 10);
            } else {
                number[i] = (char) ('0' + num);
                break;
            }

        }

        return isOverflow;
    }

    private StringBuilder sb = new StringBuilder();

    private void print(char[] number) {
        sb.setLength(0);
        boolean skip = true;
        for (int i = 0; i < number.length; i++) {

            if (skip && number[i] != '0') {
                skip = false;
            }
            if (!skip) {
                sb.append(number[i]);
            }
        }
        System.out.print(sb.toString() + ",");
    }
}
