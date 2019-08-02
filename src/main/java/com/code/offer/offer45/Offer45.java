package com.code.offer.offer45;

import java.util.Arrays;

public class Offer45 {

    /*
     * 圆圈中剩下的最后数字
     *
     * 1. 暴力推算
     *     ->> 如果输入数组过大，循环次数非常多
     *
     * 2. 数学推算公式
     *
     *             0, 当 n=1
     *  f(n,m)=﹛
     *             [f(n-1,m)+m]%n,n>1
     *
     * <*> 推算真难
     *
     */
    public static void main(String[] args) {

        Offer45 test = new Offer45();
        test.output(new int[]{1, 2}, 1);
        test.output(new int[]{1, 2, 3, 4, 5, 6}, 1);
        test.output(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }

    private void output(int[] array, int m) {
        System.out.println("input " + Arrays.toString(array) + ", m = " + m);
        if (array == null || array.length == 0) {
            return;
        }

        int index = lastRemaining(array.length, m);
        if (index == -1) {
            System.out.println(" |-- output error");
        } else {
            System.out.println(" |-- output >> " + array[index]);
        }
    }

    private int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
