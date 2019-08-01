package com.code.offer.offer10;

public class Offer10 {

    /*
     * 二进制中2的个数
     */
    public static void main(String[] args) {

        Offer10 test = new Offer10();
        test.getNumberOf1(0);
        test.getNumberOf1(1);
        test.getNumberOf1(2);
        test.getNumberOf1(3);
        test.getNumberOf1(4);
        test.getNumberOf1(9);
        test.getNumberOf1(-9);

        test.getNumberOf1(-1);
        test.getNumberOf1(-2);
        test.getNumberOf1(-3);
    }

    private void getNumberOf1(int number) {

        System.out.println("input number = " + number + " >> " + Integer.toBinaryString(number));

        System.out.println(" |-- output method_1 >> count = " + numberOf1_1(number));
        System.out.println(" |-- output method_2 >> count = " + numberOf1_2(number));

    }

    private int numberOf1_1(int number) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {

            if ((number & flag) != 0) {
                count++;
            }

            flag = flag << 1;

        }
        return count;
    }

    /*
     * 把一个整数减一，再与原整数进行与运算，能把该整数最右边的 1 去掉
     * 原整数有几个 1 ，就进行几次与运算
     */
    private int numberOf1_2(int number) {
        int count = 0;

        while (number != 0) {

            number = number & (number - 1);
            count++;
        }
        return count;
    }
}
