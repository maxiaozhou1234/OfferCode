package com.code.offer.offer31;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer31 {

    /*
    * 连续子数组最大和
     */
    public static void main(String[] args) {
        Offer31 test = new Offer31();
        test.findGreatestSumOfSub(new int[]{1,-2,3,10,-4,7,2,-5});
        test.findGreatestSumOfSub(new int[]{1,-2,3,10,-15,1,5,9});
    }

    private void findGreatestSumOfSub(int[] array) {

        System.out.println("input >> " + Arrays.toString(array));
        if (array == null || array.length == 0) {
            System.out.println("input error");
            return;
        }

        Utils.initTime();
        int sum = 0, greatestSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (sum > greatestSum) {
                greatestSum = sum;
            }
        }
        System.out.println(" |-- output >> " + greatestSum);
        Utils.timeConsuming();
    }
}
