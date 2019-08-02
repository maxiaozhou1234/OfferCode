package com.code.offer.offer28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Offer28 {

    /*
     * 字符串的排列
     */
    public static void main(String[] args) {
        Offer28 test = new Offer28();

        System.out.println("test null array >> ");
        test.combination(null);

        System.out.println("test normal array >> ");
        test.combination(new char[]{'a', 'b', 'c', 'd'});

        System.out.println("test repeat array >> ");
        test.combination(new char[]{'a', 'b', 'a', 'd', 'b'});
    }

    public void combination(char[] array) {

        if (array == null || array.length == 0) {
            System.out.println("empty array.");
            return;
        }
        System.out.println("|--- input >> " + Arrays.toString(array));

        HashSet<Character> set = new HashSet<>(array.length);
        for (char c : array) {
            set.add(c);
        }
        char[] newArray = new char[set.size()];
        int index = 0;
        for (Character c : set) {
            newArray[index++] = c;
        }
        System.out.println("|--- newArray >> " + Arrays.toString(newArray));
        Stack<Character> stack = new Stack<>();
        for (int i = 1; i < newArray.length; i++) {
            combination(newArray, 0, i, stack);
        }
    }


    private void combination(char[] array, int start, int len, Stack<Character> stack) {
        if (len == 0) {
            System.out.print(" |-- ");
            System.out.println(stack.toString());
            return;
        }
        if (start == array.length)
            return;
        stack.push(array[start]);
        combination(array, start + 1, len - 1, stack);

        stack.pop();
        combination(array, start + 1, len, stack);
    }
}
