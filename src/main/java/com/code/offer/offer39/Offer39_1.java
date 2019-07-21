package com.code.offer.offer39;

import com.code.offer.Utils;

import java.util.ArrayDeque;

public class Offer39_1 {

    /*
    * 判断一棵树是不是平衡二叉树
    *
    * 即树的左子树与右子树深度差不超过1
    * java 语言没有指针传递，基本类型是值传递
    * 所以增加了参数level表明从根往上的深度
    *
    */
    public static void main(String[] args) {

        Offer39_1 test = new Offer39_1();
        Node root = test.createTree();

        System.out.print("input >> ");
        test.printTree(root);
        System.out.println();

        Utils.initTime();
        boolean isBalance = test.decodeTreeDepth(root);
        System.out.println(" |-- out >> isBalance:" + isBalance);
        Utils.timeConsuming();
    }


    private boolean decodeTreeDepth(Node node) {

        if (node == null) {
            return true;
        }
        boolean l = decodeTreeDepth(node.left);
        boolean r = decodeTreeDepth(node.right);

        int ll = 0, rl = 0;
        if (node.left != null) {
            ll = node.left.level;
        }
        if (node.right != null) {
            rl = node.right.level;
        }

        node.level = Math.max(ll, rl) + 1;

        return l && r && Math.abs(ll - rl) < 2;
    }


    //=========================

    class Node {
        Node left;
        Node right;
        int value;
        int level;

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
        Node[] node = new Node[14];
        for (int i = 0; i < 14; i++) {
            node[i] = new Node(i);
        }
        for (int i = 0; i < 14; i++) {
            if (2 * i + 1 < 14) {
                node[i].left = node[2 * i + 1];
            }
            if (2 * i + 2 < 14) {
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
