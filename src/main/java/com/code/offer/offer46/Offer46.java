package com.code.offer.offer46;

public class Offer46 {

    /*
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public static void main(String[] args) {

        Offer46 test = new Offer46();

        int sum;

        sum= test.sum_1(3);
        System.out.println(sum);


        sum= test.sum_2(3);
        System.out.println(sum);
    }

    private int sum_1(int n) {
        int sum = n;

        boolean ans = (n > 0) && ((sum += sum_1(n - 1)) > 0);

        return sum;
    }

    private int sum_2(int n) {
        int sum = n;

        boolean ans = (n == 0) || ((sum += sum_2(n - 1)) > 0);

        return sum;
    }

}
