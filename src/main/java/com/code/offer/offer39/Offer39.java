package com.code.offer.offer39;

import com.code.offer.Utils;

import java.util.ArrayDeque;

public class Offer39 {

    /*
     * 二叉树的深度
     *
     */
    public static void main(String[] args) {

        Offer39 test = new Offer39();
        Node root = test.createTree();

        System.out.print("input >> ");
        test.printTree(root);
        System.out.println();

        Utils.initTime();
        int depth = test.getTreeDepth(root);
        System.out.println(" |-- out >> depth:" + depth);
        Utils.timeConsuming();
    }

    private int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getTreeDepth(node.left);
        int right = getTreeDepth(node.right);
        return Math.max(left, right) + 1;
    }

    //=====================================//

    class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * -----------1
     * ---------/   \
     * --------2     3
     * ------/  \   / \
     * -----4    5 6  7
     * ----/ \  /
     * ---8  9 10
     */
    private Node createTree() {
        Node[] node = new Node[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new Node(i);
        }
        for (int i = 0; i < 10; i++) {
            if (2 * i + 1 < 10) {
                node[i].left = node[2 * i + 1];
            }
            if (2 * i + 2 < 10) {
                node[i].right = node[2 * i + 2];
            }
        }
        return node[0];
    }

    private void printTree(Node root) {

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            printTree(queue.pollFirst(), queue);
        }

    }

    private void printTree(Node root, ArrayDeque<Node> queue) {
        if (root == null)
            return;
        System.out.print(root.value + " - ");
        if (root.left != null) {
            queue.addLast(root.left);
        }
        if (root.right != null) {
            queue.addLast(root.right);
        }
    }
}
