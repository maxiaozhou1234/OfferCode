package com.code.offer;

public class Utils {

    private static long time;

    public static void initTime() {
        time = System.currentTimeMillis();
    }

    public static void timeConsuming() {
        System.out.println(" |-- time consuming: " + (System.currentTimeMillis() - time) + "ms");
    }

}
