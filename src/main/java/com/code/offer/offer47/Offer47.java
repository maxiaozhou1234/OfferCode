package com.code.offer.offer47;

public class Offer47 {

    /*
     * 不用加减乘除做加法
     */
    public static void main(String[] args) {

        Offer47 test = new Offer47();
        System.out.println(test.plus(1, 4));
    }

    private int plus(int a, int b) {

        int sum, carry;

        do {
            sum = a ^ b;//普通相加，但不进位
            carry = (a & b) << 1;//进位

            a = sum;
            b = carry;
        } while (b != 0);

        return sum;
    }
}
