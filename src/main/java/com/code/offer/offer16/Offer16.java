package com.code.offer.offer16;

import com.code.offer.Utils;
import com.code.offer.bean.SingleNode;

import java.util.Stack;

public class Offer16 {

    /*
     * 反转链表
     */
    public static void main(String[] args) {
        Offer16 test = new Offer16();

        SingleNode result;

        result = test.reverseChainBySelf(null);
        Utils.printSingleNode(result);

        result = test.reverseChainBySelf(Utils.createSingleNode(1));
        Utils.printSingleNode(result);

        result = test.reverseChainBySelf(Utils.createSingleNode(4000));
        Utils.printSingleNode(result);


        //===================================//
        //使用栈缺点，数据量过大会导致 OOM，使用额外空间
        //而且需要两次变量，先入栈，再出栈，pass!

        result = test.reverseChainUseStack(Utils.createSingleNode(4000));
        Utils.printSingleNode(result);
    }

    private SingleNode reverseChainBySelf(SingleNode node) {
        if (node == null) {
            System.out.println("input node is null");
            return null;
        }
        System.out.println("input node = " + node.value);

        Utils.initTime();

        SingleNode reverseHead = null;
        SingleNode n = node, pre = null;

        while (n != null) {

            SingleNode next = n.next;
            if (next == null) {
                reverseHead = n;
            }

            n.next = pre;
            pre = n;

            n = next;
        }
        Utils.timeConsuming();
        return reverseHead;
    }

    private SingleNode reverseChainUseStack(SingleNode node) {

        if (node == null) {
            System.out.println("input node is null");
            return null;
        }

        System.out.print("input >> ");
        Utils.printSingleNode(node);

        Utils.initTime();
        Stack<SingleNode> stack = new Stack<>();
        SingleNode n = node;
        while (n != null) {
            stack.push(n);
            n = n.next;
        }

        SingleNode head = null;
        if (!stack.isEmpty()) {
            head = stack.pop();
            n = head;
        }
        while (!stack.isEmpty()) {
            SingleNode next = stack.pop();
            n.next = next;
            n = next;
        }

        node.next = null;//把原链的头下一个指针移除

        Utils.timeConsuming();
        return head;
    }

}
