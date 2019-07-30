package com.code.offer;

import com.code.offer.bean.Node;

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

    public static Node createTree() {
        //4 6 8 10 12 14 16
        Node node = new Node(10);

        Node left, right;

        left = new Node(6);
        left.left = new Node(4);
        left.right = new Node(8);

        right = new Node(14);
        right.left = new Node(12);
        right.right = new Node(16);

        node.left = left;
        node.right = right;

        return node;
    }

}
