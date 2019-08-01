package com.code.offer;

import com.code.offer.bean.Node;
import com.code.offer.bean.SingleNode;

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

    public static SingleNode createSingleNode(int count) {
        SingleNode head = new SingleNode(1);

        SingleNode node = head;
        for (int i = 2; i < count + 1; i++) {
            node.next = new SingleNode(i);
            node = node.next;
        }

        return head;
    }

    public static SingleNode createSingleNodeByArray(int[] array) {
        if (array == null || array.length == 0)
            throw new NullPointerException("array is null or empty");

        SingleNode head = new SingleNode(array[0]);

        SingleNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new SingleNode(array[i]);
            node = node.next;
        }

        return head;
    }

    public static void printSingleNode(SingleNode node) {
        if (node == null) {
            System.out.println(" |-- output SingleNode is null");
            return;
        }
        SingleNode n = node;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.value).append(",");
            n = n.next;
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        System.out.println(" |-- print >> " + sb.toString());
    }

}
