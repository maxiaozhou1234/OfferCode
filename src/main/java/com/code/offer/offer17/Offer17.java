package com.code.offer.offer17;

import com.code.offer.Utils;
import com.code.offer.bean.SingleNode;

public class Offer17 {

    /*
     * 合并两个排序的链表
     */
    public static void main(String[] args) {
        Offer17 test = new Offer17();

        SingleNode a = Utils.createSingleNodeByArray(new int[]{1, 3, 5, 7, 8, 9, 10, 21, 27, 30});
        SingleNode b = Utils.createSingleNodeByArray(new int[]{2, 4, 5, 6, 9, 13, 20, 22});

        Utils.initTime();
        SingleNode node = test.combine(a, b);
        Utils.printSingleNode(node);
        Utils.timeConsuming();

        System.out.println("=======================");

        SingleNode c = Utils.createSingleNodeByArray(new int[]{1, 3, 5, 7, 8, 9, 10, 21, 27, 30});
        SingleNode d = Utils.createSingleNodeByArray(new int[]{2, 4, 5, 6, 9, 13, 20, 22});

        Utils.initTime();

        node = test.merge(c, d);

        Utils.printSingleNode(node);
        Utils.timeConsuming();
    }

    //顺序执行
    private SingleNode combine(SingleNode a, SingleNode b) {
        if (a == null && b == null) {
            System.out.println("input nodes both null");
            return null;
        }
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }
        System.out.print("input >> a ");
        Utils.printSingleNode(a);
        System.out.print("input >> b ");
        Utils.printSingleNode(b);
        System.out.println();

        SingleNode head;

        SingleNode first = a, second = b;

        if (first.value < second.value) {
            head = first;
            first = first.next;
        } else {
            head = second;
            second = second.next;
        }

        SingleNode node = head;

        while (first != null && second != null) {

            if (first.value < second.value) {
                node.next = first;
                first = first.next;
            } else {
                node.next = second;
                second = second.next;
            }
            node = node.next;
        }
        if (first != null) {
            node.next = first;
        }

        if (second != null) {
            node.next = second;
        }

        return head;
    }

    //递归
    private SingleNode merge(SingleNode a, SingleNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        SingleNode head;
        if (a.value < b.value) {
            head = a;
            head.next = merge(a.next, b);
        } else {
            head = b;
            head.next = merge(a, b.next);
        }
        return head;
    }
}
