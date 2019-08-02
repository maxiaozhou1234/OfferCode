package com.code.offer.offer33;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Offer33 {

    /*
    * 输入一个正整数数组，把数组所有数字拼接起来排成一个数，
    * 打印能拼接的所有数字中最小的一个。
    * 如输入[3,32,321]，则打印出这3个数字能排成的最小数字321323
    *
    * */

    public static void main(String[] args) {
        Offer33 test = new Offer33();
        test.minNumber(new int[]{3, 32, 321});
        test.minNumber(new int[]{3, 2, 6});
        test.minNumber(new int[]{});
        test.minNumber(new int[]{1});
        test.minNumber(new int[]{22, 33, 22, 1});
    }

    private void minNumber(int[] num) {

        if (num == null || num.length == 0) {
            System.out.println("empty array.");
            return;
        }
        System.out.println("input >> " + Arrays.toString(num));
        String[] str = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            str[i] = String.valueOf(num[i]);
        }

        Collections.sort(Arrays.asList(str), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });

//        Integer[] copy = new Integer[num.length];
//        for (int i = 0; i < num.length; i++) {
//            copy[i] = num[i];
//        }
//
//        Collections.sort(Arrays.asList(copy), new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                String a = String.valueOf(o1) + String.valueOf(o2);
//                String b = String.valueOf(o2) + String.valueOf(o1);
//                return a.compareTo(b);
//            }
//        });

        System.out.print("out >> the smallest number:");
        for (String s : str) {
            System.out.print(s);
        }
        System.out.println();

    }
}
