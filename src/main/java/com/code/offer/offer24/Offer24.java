package com.code.offer.offer24;

import com.code.offer.Utils;

public class Offer24 {

    /*
     * 二叉搜索树的后序遍历序列
     *
     * 输入一个数组，判读是不是某一二叉搜索树的后序遍历序列
     */
    public static void main(String[] args) {
        Offer24 test = new Offer24();

        test.verify(new int[]{5, 7, 6, 9, 11, 10, 8});
        test.verify(new int[]{7, 4, 6, 5});

    }

    private void verify(int[] sequence) {
        if (Utils.checkEmptyArray(sequence)) {
            boolean b = verifySequenceOfBTS(sequence, 0, sequence.length - 1);
            System.out.println(" |-- output >> result: " + b);
        }
    }

    private boolean verifySequenceOfBTS(int[] sequence, int start, int end) {

        if (start == end) {
            return true;
        }

        int root = sequence[end];

        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                break;
            }
        }
        if (j != end) {
            return false;
        }

        boolean left = verifySequenceOfBTS(sequence, start, i - 1);

        boolean right = verifySequenceOfBTS(sequence, i, end - 1);


        return left && right;
    }
}
