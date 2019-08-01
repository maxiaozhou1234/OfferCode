package com.code.offer.offer13;

import com.code.offer.Utils;
import com.code.offer.bean.SingleNode;

public class Offer13 {

    /*
     * 在O(1)时间删除单向链表节点
     */
    public static void main(String[] args) {

        Offer13 test = new Offer13();

        SingleNode after;

        after = test.delete(Utils.createSingleNode(1), 1);
        test.printSingleNode(after);

        after = test.delete(Utils.createSingleNode(1), 6);
        test.printSingleNode(after);

        after = test.delete(Utils.createSingleNode(7), 3);
        test.printSingleNode(after);

        after = test.delete(Utils.createSingleNode(7), 7);
        test.printSingleNode(after);

        after = test.delete(Utils.createSingleNode(7), 1);
        test.printSingleNode(after);
    }

    private SingleNode delete(SingleNode node, int nodeValue) {

        System.out.println("input node value=" + nodeValue);
        if (node == null) {
            System.out.println("input null");
            return null;
        }

        SingleNode n = node;
        boolean result = false;
        while (n != null) {

            if (n.value == nodeValue) {
                result = true;

                SingleNode next = n.next;
                if (next == null) {//尾节点
                    if (n == node) {//只有一个节点的链表
                        System.out.println(" |-- output >> the chain has one node,and should delete itself.");
                        return null;
                    } else {

                        n = node;
                        SingleNode pre = null;
                        while (n != null) {
                            if (n.value == nodeValue) {
                                pre.next = n.next;
                                n.next = null;
                                break;
                            }
                            pre = n;
                            n = n.next;
                        }

                    }

                } else {
                    n.value = next.value;
                    n.next = next.next;
                    next.next = null;
                }

                break;
            }

            n = n.next;
        }
        System.out.println(" |-- output >> " + (result ? "success" : "fail,no found " + nodeValue));
        return node;
    }

    private void printSingleNode(SingleNode node) {
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
