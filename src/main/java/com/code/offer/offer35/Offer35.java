package com.code.offer.offer35;

import com.code.offer.Utils;

public class Offer35 {

    /*
    * 第一个只出现一次的字符
    * 输入 abaccdef
    * 输出 b
    *
    * 如果输入是汉字如何处理？
    * */
    public static void main(String[] args) {
        Offer35 test = new Offer35();

        test.firstNotRepeatChar(null);
        test.firstNotRepeatChar("abc");
        test.firstNotRepeatChar("aabbccdd");
        test.firstNotRepeatChar("abaccdef");
        test.firstNotRepeatChar("#$%^&a-@#$*%^baccdef");

    }

    private void firstNotRepeatChar(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("empty input >> " + str);
            return;
        }
        System.out.println("input >> " + str);

        Utils.initTime();

        char[] array = str.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>(array.length);
//        for (char key : array) {
//            Integer count = map.get(key);
//            if (count == null) {
//                count = 0;
//            }
//            count += 1;
//            map.put(key, count);
//        }
//        Character result = null;
//        for (char c : array) {
//            if (1 == map.get(c)) {
//                result = c;
//                break;
//            }
//        }

        Character result = null;
        int[] hash = new int[256];
        for (char c : array) {
            hash[(int) c]++;
        }

        for (char c : array) {
            if (1 == hash[(int) c]) {
                result = c;
                break;
            }
        }

        if (result == null) {
            System.out.println(" |-- without repeat once char!");
        } else {
            System.out.println(" |-- out >> " + result);
        }
        Utils.timeConsuming();
    }
}
