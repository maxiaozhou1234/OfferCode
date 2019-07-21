package com.code.offer.offer40;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer40 {

    /*
    * 数组中只出现一次的数字
    * 1.只有一个出现一次的数字
    * 2.两个出现一次的数字
     */
    public static void main(String[] main) {
        Offer40 test = new Offer40();

        System.out.println("出现一次的数字测试");
        Utils.initTime();
        test.getOnceNumber(new int[]{});
        test.getOnceNumber(new int[]{1});
        test.getOnceNumber(new int[]{1, 1});
        test.getOnceNumber(new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5});
        test.getOnceNumber(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5});
        Utils.timeConsuming();

        System.out.println("出现两次的数字测试");
        Utils.initTime();
        test.getOnceNumber2(new int[]{});
        test.getOnceNumber2(new int[]{1});
        test.getOnceNumber2(new int[]{1, 1});
        test.getOnceNumber2(new int[]{1, 1, 2});
        test.getOnceNumber2(new int[]{1, 1, 2, 3});
        test.getOnceNumber2(new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4});
        test.getOnceNumber2(new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5});
        Utils.timeConsuming();
    }

    //只有一个数字出现一次
    private void getOnceNumber(int[] numbers) {

        System.out.println("input >> " + Arrays.toString(numbers));
        if (numbers == null || numbers.length % 2 == 0) {
            System.out.println("empty array or input array length is double.");
            return;
        }

        int resultOr = 0;
        for (int i = 0; i < numbers.length; i++) {
            resultOr ^= numbers[i];
        }
        System.out.println(" |-- output >> " + resultOr);
    }

    //数组中两个出现一次的数字
    private void getOnceNumber2(int[] numbers) {

        System.out.println("input >> " + Arrays.toString(numbers));
        if (numbers == null || numbers.length == 0) {
            System.out.println("empty array.");
            return;
        }

        int resultOr = 0;
        for (int i = 0; i < numbers.length; i++) {
            resultOr ^= numbers[i];
        }
        int index = getFirstBitIs1(resultOr);
        int a = 0, b = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (isBit(numbers[i], index)) {
                a ^= numbers[i];
            } else {
                b ^= numbers[i];
            }
        }

        if (checkNumberInArray(numbers, a)) {
            System.out.println(" |-- output >> first= " + a);
        } else {
            System.out.println(" |-- not found first number.");
        }

        if (checkNumberInArray(numbers, b)) {
            System.out.println(" |-- output >> second= " + b);
        } else {
            System.out.println(" |-- not found second number");
        }

    }


    private int getFirstBitIs1(int or) {
        int index = 0;
        while ((or & 1) == 0 && index < 8) {
            or = or >> 1;
            index++;
        }
        return index;
    }

    private boolean isBit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

    private boolean checkNumberInArray(int[] number, int num) {
        for (int i : number) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}
