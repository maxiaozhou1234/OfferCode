package com.code.offer.offer11;

import com.code.offer.Utils;

public class Offer11 {

    /*
     * 数值的整数次方
     *
     * 不使用库函数，不考虑大数
     */
    public static void main(String[] args) {
        Offer11 test = new Offer11();

        test.power(0, 4);
        test.power(2, -2);
        test.power(8.0, 32);

        test.power2(8.0, 32);
    }

    private double power(double base, int exponent) {

        System.out.println("input base: " + base + ", exponent: " + exponent);
        if (equals(base, 0.0)) {
            System.out.println(" |-- output >> " + base);
            return 0.0;
        }

        Utils.initTime();
        int absExponent = exponent < 0 ? -exponent : exponent;
        double result = 1.0;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1.0 / result;
        }

        System.out.println(" |-- output >> " + base + "^" + exponent + " = " + result);
        Utils.timeConsuming();
        return result;
    }

    private static boolean equals(double d1, double d2) {
        if (d1 - d2 < 0.0000001 && d1 - d2 > -0.0000001) {
            return true;
        } else {
            return false;
        }
    }

    //====================================================

    private double power2(double base, int exponent) {
        System.out.println("input base: " + base + ", exponent: " + exponent);
        if (equals(base, 0.0)) {
            System.out.println(" |-- output >> " + base);
            return 0.0;
        }
        Utils.initTime();
        int absExponent = exponent < 0 ? -exponent : exponent;
        double result = doPower(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        System.out.println(" |-- output >> " + base + "^" + exponent + " = " + result);
        Utils.timeConsuming();
        return result;
    }

    // a^n = a^(n/2) * a^(n/2)  ---n为偶数
    // a^n = a^[(n-1)/2)] * a^[(n-1)/2)] * n  ---n为奇数
    private double doPower(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = doPower(base, exponent >> 1);
        result *= result;

        if ((exponent & 0x01) == 1) {
            result *= base;
        }

        return result;
    }
}
