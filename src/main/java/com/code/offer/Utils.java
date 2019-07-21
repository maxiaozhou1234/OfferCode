package com.code.offer;

import java.util.Arrays;

public class Utils {

    private static long time;

    public static void initTime() {
        time = System.currentTimeMillis();
    }

    public static void timeConsuming() {
        System.out.println(" |-- time consuming: " + (System.currentTimeMillis() - time) + "ms");
    }

    public static boolean checkEmptyArray(int[] array) {
        System.out.println("input >> " + Arrays.toString(array));
        if (array == null || array.length == 0) {
            System.out.println("empty array.");
            return false;
        }
        return true;
    }

}
