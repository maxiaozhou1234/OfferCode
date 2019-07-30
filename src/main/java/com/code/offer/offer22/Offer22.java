package com.code.offer.offer22;

import java.util.Arrays;
import java.util.Stack;

public class Offer22 {

    /*
     * 栈的压入、弹出序列
     * 输入两个序列，第一序列表示栈的压入顺序，判断第二个序列是否弹出顺序
     * 输入[1,2,3,4,5] 则 [4,5,3,2,1] 是弹出序列
     */
    public static void main(String[] args) {
        Offer22 test = new Offer22();
        test.checkSequence(new int[]{1, 2, 3}, new int[]{4, 3, 5, 1, 2});
        test.checkSequence(new int[]{1, 2, 3, 4, 5}, new int[]{4, 0, 5, 1, 2});
        test.checkSequence(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});

        test.checkSequence(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }

    private void checkSequence(int[] push, int[] pop) {
        System.out.println("input >> push: " + Arrays.toString(push) + " pop: " + Arrays.toString(pop));
        if (push == null || pop == null || push.length != pop.length) {
            System.out.println("input error!");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < push.length; i++) {
            if (push[i] != pop[popIndex]) {
                stack.push(push[i]);
            } else {
                popIndex++;
                while (!stack.isEmpty()) {
                    if (stack.peek() == pop[popIndex]) {
                        popIndex++;
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }
        if (popIndex == pop.length && stack.isEmpty()) {
            System.out.println(" |-- output >> is match");
        } else {
            System.out.println(" |-- output >> is not match");
        }
    }
}
