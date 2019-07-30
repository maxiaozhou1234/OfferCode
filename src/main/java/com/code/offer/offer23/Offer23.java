package com.code.offer.offer23;

import com.code.offer.Utils;
import com.code.offer.bean.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Offer23 {

    /*
     * 从上往下打印二叉树
     * （广度优先遍历）
     */
    public static void main(String[] args) {
        Offer23 test = new Offer23();

        Node tree = Utils.createTree();

        test.printTree(tree);
        System.out.println();
        System.out.println("----------");
        test.print2(tree);
    }

    private Queue<Node> queue = new ArrayDeque<>();

    private void printTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
        printTree(queue.poll());
    }

    private void print2(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            System.out.print(node.value + " ");
        }
    }

}
