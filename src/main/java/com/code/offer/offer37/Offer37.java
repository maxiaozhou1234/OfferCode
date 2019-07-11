package com.code.offer.offer37;

import com.code.offer.Utils;

import java.util.Arrays;

public class Offer37 {

    /*
     * 两个链表的第一个公共节点
     * */
    public static void main(String[] args) {

        Offer37 test = new Offer37();

        test.createNode(new int[]{1, 2, 3, 4}, new int[]{4});
        test.createNode(new int[]{1, 2, 3, 4}, new int[]{7});

        int[] value1 = {3, 5, 4, 77, 8, 2, 4, 1, 9, 0, 56, 34};
        int[] value2 = {77, 8, 2, 4, 1, 9, 0, 56, 34};
        test.createNode(value1, value2);


    }

    private void createNode(int[] value1, int[] value2) {
        if (value1 == null || value1.length == 0) {
            System.out.println("error empty array1");
            return;
        }
        if (value2 == null || value2.length == 0) {
            System.out.println("error empty array2");
            return;
        }

        System.out.println("input array1 >> " + Arrays.toString(value1));
        System.out.println("input array2 >> " + Arrays.toString(value2));

        Node a = new Node(value1[0]);
        Node tmp = a;
        for (int i = 1; i < value1.length; i++) {
            tmp.next = new Node(value1[i]);
            tmp = tmp.next;
        }
        Node b = new Node(value2[0]);
        tmp = b;
        for (int i = 1; i < value2.length; i++) {
            tmp.next = new Node(value2[i]);
            tmp = tmp.next;
        }

        findFirstCommonNode(a, b);
    }

    private void findFirstCommonNode(Node first, Node second) {
        if (first == null || second == null) {
            System.out.println("node is null >> node1=" + first + " node2=" + second);
            return;
        }

        Utils.initTime();
        int len1 = getNodeLength(first);
        int len2 = getNodeLength(second);

        Node nodeLong, nodeShort;
        int dif;
        if (len1 > len2) {
            nodeLong = first;
            nodeShort = second;
            dif = len1 - len2;
        } else {
            nodeLong = second;
            nodeShort = first;
            dif = len2 - len1;
        }

        for (int i = 0; i < dif; i++) {
            nodeLong = nodeLong.next;
        }

        while (nodeLong != null && nodeShort != null && nodeLong.value != nodeShort.value) {
            nodeLong = nodeLong.next;
            nodeShort = nodeShort.next;
        }
        if (nodeLong != null) {
            System.out.println(" |-- found common:" + nodeLong.value);
        } else {
            System.out.println(" |-- without common node");
        }
        Utils.timeConsuming();
    }

    private int getNodeLength(Node node) {
        if (node == null) return 0;
        int len = 0;
        Node n = node;
        while (n.next != null) {
            n = n.next;
            len++;
        }
        return len;
    }

    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}
