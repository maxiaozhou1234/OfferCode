package com.code.offer.offer42;

import com.code.offer.Utils;

public class Offer42 {

    /*
    * 翻转单词顺序
    * 如输入 i am a student.
    * 输出：student. a am i
     */
    public static void main(String[] args) {
        Offer42 test = new Offer42();
//        test.reverseSentence(null);
//        test.reverseSentence("");
//        test.reverseSentence("abc");
//        test.reverseSentence("abc d");
//        test.reverseSentence("i am a student.");

        test.reverseWithIndex("abcdef", 0);
        test.reverseWithIndex("abcdef", 1);
        test.reverseWithIndex("abcdef", 2);
    }

    private void reverseSentence(String str) {
        System.out.println("input >> " + str);
        if (str == null || str.length() == 0) {
            System.out.println(" |-- input error");
            return;
        }

        Utils.initTime();

        char[] array = str.toCharArray();
        reverse(array, 0, array.length - 1);
        int start = 0, end = 0;
        for (int i = 0; i <= array.length; i++) {
            if (i == array.length || array[i] == ' ') {
                reverse(array, start, end - 1);
                start = end + 1;
            }
            end++;
        }
//        for (char c : array) {
//            if (c == ' ') {
//                reverse(array, start, end - 1);
//                start = end + 1;
//            }
//            end++;
//        }

        System.out.println(" |-- output >>" + new String(array));
        Utils.timeConsuming();

    }

    private void reverse(char[] array, int start, int end) {

        while (start < end) {
            char tmp = array[end];
            array[end] = array[start];
            array[start] = tmp;
            start++;
            end--;
        }
    }

    /*
    * 变种：左旋字符串
    * 如输入 abcdef 2
    * 输出 cdefab
     */
    private void reverseWithIndex(String str, int index) {
        System.out.println("input >> " + str + " -- " + index);
        if (str == null || str.length() == 0 || index < 0 || index > str.length()) {
            System.out.println(" |-- input error");
            return;
        }

        //先翻转整句，再翻转单个
//        Utils.initTime();
//        char[] array = str.toCharArray();
//        reverse(array, 0, array.length - 1);
//        int end = array.length - 1 - index;
//        reverse(array, 0, end);
//        reverse(array, end + 1, array.length - 1);
//        System.out.println(" |-- output >>" + new String(array));
//        Utils.timeConsuming();

        //先翻转单个，再翻转整句
        Utils.initTime();
        char[] array = str.toCharArray();
        reverse(array, 0, index - 1);
        reverse(array, index, array.length - 1);
        reverse(array, 0, array.length - 1);
        System.out.println(" |-- output >>" + new String(array));
        Utils.timeConsuming();
    }
}
