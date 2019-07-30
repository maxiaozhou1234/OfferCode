package com.code.offer.offer21;

import java.util.Stack;

public class Offer21 {

    /*
     * 包含min函数的栈
     */
    public static void main(String[] args) {
        Offer21 test = new Offer21();

        int[] array = new int[]{2, 5, 3, 6, 5, 1, 8, 6, 9};
        for (int i = 0; i < array.length; i++) {
            test.push(array[i]);
        }

        System.out.println("the min number is " + test.min());
        int min = test.min();
        while (min != test.pop()) ;
        System.out.println("the second min number is " + test.min());
    }

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    private int currentMin;

    private void push(int n) {
        data.push(n);
        if (min.isEmpty()) {
            currentMin = n;
        } else if (currentMin > n) {
            currentMin = n;
        }
        min.push(currentMin);
    }

    private int pop() {
        min.pop();
        currentMin = min.peek();
        return data.pop();
    }

    private int min() {
        return min.peek();
    }
}
