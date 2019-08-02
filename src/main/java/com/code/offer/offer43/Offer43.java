package com.code.offer.offer43;

public class Offer43 {

    /*
     * n个骰子的点数
     *
     * 把n个骰子扔到地上，往上一面点数和为s，输出 s 所有可能值出现的概率
     */
    public static void main(String[] args) {

        Offer43 test = new Offer43();

        test.printProbability(1);
        test.printProbability(2);
        test.printProbability(3);
    }

    private final static int MAX = 6;

    /*
     * 对于n个骰子，出现的和范围为 [n,6n] 出现所有可能值总数为 6^n
     *
     * 当n=1时，和范围[1,6],所有点出现次数记为p，且都为 1
     * 当n=2时，出现的点和[2,12]，出现次数p(s) = sum(p(s-1)+p(s-2)+p(s-3)+p(s-4)+p(s-5)+p(s-6)) 当且 s-x >0,x∈[1,6]
     *
     */
    private void printProbability(int number) {
        System.out.println("input " + number);
        if (number < 1) {
            return;
        }
        int[][] probability = new int[2][];
        probability[0] = new int[number * MAX + 1];
        probability[1] = new int[number * MAX + 1];

        int flag = 0;
        for (int i = 1; i <= MAX; i++) {//只有一个骰子，每个点数只出现一次
            probability[flag][i] = 1;
        }

        for (int k = 2; k <= number; k++) {

            //因为要复用数组，所以需将点数之前的重置为0
            for (int i = 0; i < k; i++) {
                probability[1 - flag][i] = 0;
            }

            for (int i = k; i <= k * MAX; i++) {
                probability[1 - flag][i] = 0;//重置旧数据

                for (int j = 1; j <= i && j <= MAX; j++) {
                    probability[1 - flag][i] += probability[flag][i - j];
                }
            }
            flag = 1 - flag;

        }

        double total = Math.pow(MAX, number);
        for (int i = number ; i <= MAX * number; i++) {
            int p = probability[flag][i];
            System.out.println(" |-- output >> " + i + ", probability = " + p + ", P = " + (p / total));
        }
    }
}
