package com.code.offer.offer44;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer44 {

    /*
     * 扑克牌顺子
     *
     * 从扑克牌随机抽出5张牌，判断是不是顺子，大小王可以为任意数字
     *
     * 定义：牌 2-10 对应数字，A为1，JQK 分别为 11,12,13 ，大小王均为0
     *
     * 思路：
     *
     * 先排序，判断有几个断点，如果断点数等于“0”个数，或者断点数为0，则为顺子，否则不是
     *
     * 如果存在重复非0数字，也说明不是顺子
     *
     */
    public static void main(String[] args) {

        Offer44 test = new Offer44();
        test.isContinuous(new int[]{1, 2, 3, 4, 5});
        test.isContinuous(new int[]{1, 2, 3, 2, 5});
        test.isContinuous(new int[]{1, 2, 3, 4, 7});
        test.isContinuous(new int[]{1, 2, 3, 5, 0});
        test.isContinuous(new int[]{1, 2, 3, 4, 0});
        test.isContinuous(new int[]{1, 0, 4, 0, 5});
    }

    private boolean isContinuous(int[] array) {

        boolean result = false;
        if (Utils.checkEmptyArray(array)) {

            int zeroCount = 0;
            for (int i = 0; i < array.length; i++) {
                if (0 == array[i]) {
                    zeroCount++;
                }
            }

            Arrays.sort(array);//排序，非考察点

            int numberGap = 0;
            for (int i = zeroCount + 1; i < array.length; i++) {

                if (array[i - 1] == array[i]) {//存在对子
                    System.out.println(" |-- output >> false");
                    return false;
                }

                numberGap += array[i] - array[i - 1] - 1;
            }

            if (zeroCount >= numberGap) {
                result = true;
                System.out.println(" |-- output >> true");
            } else {
                System.out.println(" |-- output >> false");
            }

        }


        return result;

    }
}
