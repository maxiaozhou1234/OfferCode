package com.code.offer.offer32;

public class Offer32_2 {
    //从1到n的整数中1出现的个数
    //如 输入12，1-12中1出现1,10,11,12 共5个1

    /*数学之美算法：

    n=31456; >> a=314,b=56

    a=n/i,b=n%i;
    比如a=314,b=56;
    当a的个位大于1时（也就是n的百位），百位为1的数总共出现了(a/10+1)*100次
    当a为1的时候，百位为1的数总共出现了(a/10)*100+(b+1);
    当a为0的时候，百位为1的数出现了(a/10)*100次；
    因此可以根据a的个位是否为1分成两种情况计算
    9=>a个位>=2时(a/10+1)和0=<a个位<=1时（a/10）表达式与（a+8）/10相同，
    当a个位为1时需要加上（b+1）与(a%10==1)*(b+1)相同

    */

    public static void main(String[] args) {
        Offer32_2 test = new Offer32_2();
        test.countDigitOne(12);
        test.countDigitOne(23);
        test.countDigitOne(21345);
    }

    private int countDigitOne(int n) {
        System.out.println("input >> " + n);
        long time = System.currentTimeMillis();
        int count = 0;
        int a, b;
        for (int i = 1; i <= n; i *= 10) {
            a = n / i;
            b = n % i;

            count += (a + 8) / 10 * i + (a % 10 == 1 ? (b + 1) : 0);
        }
        System.out.println(" |-- out >> count=" + count);
        System.out.println(" |-- time consuming: " + (System.currentTimeMillis() - time) + "ms");
        return count;
    }
}
