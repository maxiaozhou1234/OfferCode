package com.code.offer.offer15;

import com.code.offer.Utils;
import com.code.offer.bean.SingleNode;

public class Offer15 {

    /*
     * 链表的倒数第 k 个节点
     *
     * 扩展：
     *
     * 1.找链表的中间节点 -> 思路：两个指针，一个一次走一步，一个走两步，当快的到终点，慢的恰好在中点
     *
     * 2.链表是否为环 -> 思路：同样，一个快一个慢，当快的追上了慢的，那么就是环，如果快的到终点也没有追上慢的，则不是环
     */
    public static void main(String[] args) {

        Offer15 test = new Offer15();

        SingleNode node = Utils.createSingleNode(15);

        Utils.printSingleNode(node);
        System.out.println();

        test.printLastK(node, 0);
        test.printLastK(node, 1);
        test.printLastK(node, 14);
        test.printLastK(node, 18);
        test.printLastK(node, 3);
    }

    private void printLastK(SingleNode node, int k) {
        System.out.println("input k = " + k);
        if (node == null || k <= 0) {
            System.out.println(" |-- input node is null or k is error (k=" + k);
            return;
        }

        Utils.initTime();
        int count = 0;

        SingleNode first = node;
        SingleNode last = node;

        while (count != k - 1 && first.next != null) {
            first = first.next;
            count++;
        }

        if (count < k - 1) {
            System.out.println(" |-- output >> the chain length is smaller than k. length = " + (count + 1) + ", k = " + k);
            return;
        }

        while (first.next != null) {
            first = first.next;
            last = last.next;
        }

        System.out.println(" |-- output >> the last k node is " + last.value);
        Utils.timeConsuming();

    }
}
