package com.code.offer.offer4;

import com.code.offer.Utils;

public class Offer4 {

    /*
     * 替换空格，将输入中的空格替换为%20
     */
    public static void main(String[] args) {
        Offer4 test = new Offer4();

        test.replace("");
        test.replace(" 1 ");
        test.replace("We are happy.");
    }

    private void replace(String str) {
        System.out.println("input >> " + str);
        if (str == null || str.length() == 0) {
            System.out.println("input empty?");
            return;
        }
        Utils.initTime();
        char[] chars = new char[64];//假设足够大
        System.arraycopy(str.toCharArray(), 0, chars, 0, str.length());
        doReplace(chars, str.length());

        Utils.timeConsuming();
    }

    private void doReplace(char[] chars, int length) {

        int emptyCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                emptyCount++;
            }
        }
        int oldPoint = length - 1;
        int endPoint = length - 1 + emptyCount * 2;

        while (oldPoint >= 0) {

            if (chars[oldPoint] != ' ') {
                chars[endPoint--] = chars[oldPoint--];
            } else {
                chars[endPoint--] = '0';
                chars[endPoint--] = '2';
                chars[endPoint--] = '%';
                oldPoint--;
            }
        }
        System.out.println(" |-- output >> " + new String(chars, 0, length + emptyCount * 2));

    }
}
