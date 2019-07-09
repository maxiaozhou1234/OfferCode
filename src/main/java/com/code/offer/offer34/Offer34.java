package com.code.offer.offer34;

public class Offer34 {

    /*
    * 丑数：只包含因子 2,3,5 的数，如 6，8
    * */
    public static void main(String[] args) {
        Offer34 test = new Offer34();

        test.getUglyNumber(0);
        test.getUglyNumber(2);
        test.getUglyNumber(4);
        test.getUglyNumber(6);
        test.getUglyNumber(7);
        test.getUglyNumber(10);
        test.getUglyNumber(100);
        test.getUglyNumber(1000);

    }

    private void getUglyNumber(int index) {
        if (index <= 0) {
            System.out.println("error:index <= 0");
            return;
        }
        System.out.println("input >> index:" + index);
        long time = System.currentTimeMillis();
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;

        int ugly2 = 0;
        int ugly3 = 0;
        int ugly5 = 0;

        int curIndex = 1;

        while (curIndex < index) {

            int min = min(uglyNum[ugly2] * 2, uglyNum[ugly3] * 3, uglyNum[ugly5] * 5);
            uglyNum[curIndex++] = min;

            while (uglyNum[ugly2] * 2 <= min) {
                ugly2++;
            }

            while (uglyNum[ugly3] * 3 <= min) {
                ugly3++;
            }

            while (uglyNum[ugly5] * 5 <= min) {
                ugly5++;
            }
        }

        System.out.println(" |-- out >> " + uglyNum[index - 1]);
        System.out.println(" |-- time consuming: " + (System.currentTimeMillis() - time) + "ms");
//        System.out.println(Arrays.toString(uglyNum));
    }

    private int min(int a, int b, int c) {
        int m = a < b ? a : b;
        m = m < c ? m : c;
        return m;
    }
}
