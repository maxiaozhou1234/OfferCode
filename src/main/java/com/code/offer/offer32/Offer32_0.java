package com.code.offer.offer32;

public class Offer32_0 {
    //从1到n的整数中1出现的个数
    //如 输入12，1-12中1出现1,10,11,12 共5个1

    public static void main(String[] args) {
        Offer32_0 test = new Offer32_0();

        System.out.println(" |-- out >> count=" + test.getCount(12));
        System.out.println(" |-- out >> count=" + test.getCount(23));
        System.out.println(" |-- out >> count=" + test.getCount(21345));

    }

    //时间复杂度 O(nlogn) 假设n足够大，运行效率太低
    private int getCount(int n) {
        System.out.println("input >> " + n);
        if (n <= 0) return 0;
        if (n < 10) return 1;

        int count = 0, tmp;
        long time = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {

            tmp = i;
            while (tmp > 0) {
                if (tmp % 10 == 1) {
                    count++;
                }
                tmp = tmp / 10;
            }
        }
        System.out.println(" |-- time consuming: " + (System.currentTimeMillis() - time) + "ms");
        return count;
    }
}
