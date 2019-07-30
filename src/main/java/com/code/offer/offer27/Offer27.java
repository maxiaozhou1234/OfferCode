package com.code.offer.offer27;

import com.code.offer.Utils;
import com.code.offer.bean.Node;

public class Offer27 {

    /*
    * 二叉搜索树与双向链表
    *
    * 很明显是用中序遍历树
    * 当右子树结束，需要将右节点链接到父节点
    */
    public static void main(String[] args) {
        Offer27 test = new Offer27();

        Node root = Utils.createTree();

//        test.printNode(root);
        test.covert(root);
    }

//    private Node createTree() {
//        //4 6 8 10 12 14 16
//        Node node = new Node(10);
//
//        Node left, right;
//
//        left = new Node(6);
//        left.left = new Node(4);
//        left.right = new Node(8);
//
//        right = new Node(14);
//        right.left = new Node(12);
//        right.right = new Node(16);
//
//        node.left = left;
//        node.right = right;
//
//        return node;
//    }

    private void covert(Node root) {
        System.out.print("input >> ");
        printNode(root);
        System.out.println();
        if (root == null) {
            System.out.println(" |-- input null");
            return;
        }

        Utils.initTime();

        Node head = null;
        head = covertNode(root, head);
        while (head.left != null) {
            head = head.left;
        }

        StringBuilder sb = new StringBuilder();
        while (head.right != null) {
            sb.append(head.value).append(",");
            head = head.right;
        }
        System.out.println(" |-- output >> " + sb.delete(sb.length() - 1, sb.length()).toString());
        Utils.timeConsuming();
    }

    private Node covertNode(Node node, Node lastNode) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            lastNode = covertNode(node.left, lastNode);
        }
        node.left = lastNode;
        if (lastNode != null) {
            lastNode.right = node;
        }

        lastNode = node;

        if (node.right != null) {
            lastNode = covertNode(node.right, lastNode);
        }
        return lastNode;
    }

    private void printNode(Node node) {
        if (node == null) {
            return;
        }
        printNode(node.left);
        System.out.print(" " + node.value + " ");
        printNode(node.right);

    }
}
