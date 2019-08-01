package com.code.offer.offer9;

import com.code.offer.Utils;

public class Offer9 {

    /*
     * 斐波那契数列
     *
     * 当 n=40 耗时情况如下
     *
     * loop >> 102334155
     *  |-- time consuming: 1ms
     *
     * dynamic >> 102334155
     *  |-- time consuming: 0ms
     *
     * fibonacci >> 102334155
     *  |-- time consuming: 540ms
     */
    public static void main(String[] args) {

        Offer9 test = new Offer9();

        int n = 5000;

        if (n <= 40) {
            new Thread(() -> {

                Utils.initTime();
                System.out.println("fibonacci >> " + test.fibonacci(n));
                Utils.timeConsuming();
                done = true;
            }).start();
        } else {
            done = true;
        }

        Utils.initTime();
        System.out.println("loop >> " + test.loop(n));
        Utils.timeConsuming();

        Utils.initTime();
        System.out.println("dynamic >> " + test.dynamic(n));
        Utils.timeConsuming();

        while (!done) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //
            }
        }

    }

    private static boolean done = false;


    //递归
    private long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //使用循环
    private long loop(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;

        for (int i = 2; i <= n; i++) {

            b = b + a;

            a = b - a;

        }
        return b;
    }

    private long[] cache;

    //动态规划
    private long dynamic(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (cache == null) {
            cache = new long[n];
        }

        long a = cache[n - 1];
        if (a == 0) {
            cache[n - 1] = dynamic(n - 1) + dynamic(n - 2);
        }

        return cache[n - 1];
    }
}
