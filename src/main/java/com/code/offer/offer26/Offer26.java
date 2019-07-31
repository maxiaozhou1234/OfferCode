package com.code.offer.offer26;

import java.util.HashMap;

public class Offer26 {

    /*
     * 复杂链表的复制
     *
     * 除了有指向下一节点，还有指向任意节点
     *
     */
    public static void main(String[] args) {
        Offer26 test = new Offer26();
        ComplexNode node = test.createList();

        test.copy(node);

        System.out.println("\ncopy2");
        ComplexNode copy = test.copy2(node);
        test.print(node);
        System.out.println("=======");
        test.print(copy);
    }

    private void copy(ComplexNode node) {

        if (node == null) {
            System.out.println("input null");
            return;
        }
        cloneNode(node);
        cloneSibling(node);
        ComplexNode clone = splitNode(node);

        print(node);
        print(clone);

    }

    private void cloneNode(ComplexNode head) {
        if (head == null)
            return;
        ComplexNode node = head;
        while (node != null) {

            ComplexNode copy = new ComplexNode(node.value);

            copy.next = node.next;
            node.next = copy;

            node = copy.next;
        }
    }

    private void cloneSibling(ComplexNode head) {
        if (head == null) {
            return;
        }
        ComplexNode node = head;
        while (node != null) {

            ComplexNode copy = node.next;
            copy.sibling = node.sibling == null ? null : node.sibling.next;

            node = copy.next;
        }
    }

    private ComplexNode splitNode(ComplexNode head) {
        if (head == null) {
            return null;
        }
        ComplexNode node = head;
        ComplexNode newNode = head.next;
        while (node != null) {

            ComplexNode copy = node.next;

            node.next = copy.next;
            copy.next = copy.next == null ? null : copy.next.next;

            node = node.next;
        }
        return newNode;
    }

    private void print(ComplexNode node) {
        if (node == null) return;

        ComplexNode n = node;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.value);
            if (n.sibling != null) {
                sb.append("(").append(n.sibling.value).append(")");
            }
            sb.append(",");
            n = n.next;
        }
        System.out.println(" |-- output >> " + sb.toString());
    }

    private ComplexNode copy2(ComplexNode node) {
        if (node == null) {
            return null;
        }

        HashMap<ComplexNode, ComplexNode> map = new HashMap<>();
        ComplexNode n = node;
        ComplexNode copy;
        while (n != null) {
            copy = new ComplexNode(n.value);
            map.put(n, copy);
            n = n.next;
        }

        n = node;
        while (n != null) {
            ComplexNode nn = map.get(n);
            if (n.next != null) {
                nn.next = map.get(n.next);
            }
            if (n.sibling != null) {
                nn.sibling = map.get(n.sibling);
            }
            n = n.next;
        }
        return map.get(node);
    }


    private ComplexNode createList() {

        ComplexNode a = new ComplexNode(1);
        ComplexNode b = new ComplexNode(2);
        ComplexNode c = new ComplexNode(3);
        ComplexNode d = new ComplexNode(4);
        ComplexNode e = new ComplexNode(5);

        a.next = b;
        a.sibling = c;

        b.next = c;
        b.sibling = e;

        c.next = d;

        d.next = e;
        d.sibling = b;


        return a;
    }

    class ComplexNode {
        int value;
        ComplexNode next;
        ComplexNode sibling;//虚线指向

        ComplexNode(int value) {
            this.value = value;
        }
    }
}
