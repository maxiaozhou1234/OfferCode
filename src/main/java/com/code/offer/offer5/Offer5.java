package com.code.offer.offer5;

import com.code.offer.Utils;

import java.util.Random;
import java.util.Stack;

public class Offer5 {

    /*
     * 从尾到头打印链表
     *
     * 1. 使用栈，但如果数据量太大会oom
     * 2. 使用递归，同样数据量太大会溢出
     */
    public static void main(String[] args) {
        Offer5 test = new Offer5();

        Node node = test.createNode();
        System.out.println("printReverse");
        Utils.initTime();
        test.printReverse(node);
        System.out.println();
        Utils.timeConsuming();

        System.out.println("printWithStack");
        Utils.initTime();
        test.printWithStack(node);
        Utils.timeConsuming();
    }

    private void printReverse(Node node) {//如果链表太长会导致栈溢出
        if (node == null) {
            return;
        }

        printReverse(node.next);
        System.out.print(node.value + " -> ");

    }

    private void printWithStack(Node node) {
        if (node == null) {
            System.out.println("input empty");
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " -> ");
        }
        System.out.println();
    }

    private Node createNode() {
        System.out.println("create ---");
        Random random = new Random();
        int count = 0;
        Node head = new Node(10);
        Node node = head;
        while (count < 10) {
            node.next = new Node(random.nextInt(100));
            node = node.next;
            count++;
        }
        return head;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
