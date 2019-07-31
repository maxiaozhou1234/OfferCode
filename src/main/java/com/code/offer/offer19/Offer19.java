package com.code.offer.offer19;

import com.code.offer.Utils;
import com.code.offer.bean.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Offer19 {

    /*
    * 二叉树的镜像
     */
    public static void main(String[] args) {
        Offer19 test = new Offer19();

        Node tree = Utils.createTree();
        test.mirror(tree);
    }

    private void mirror(Node root) {
        if (root == null) {
            System.out.println("input null");
            return;
        }
        System.out.println("input");
        printTree(root);
        System.out.println(" |-- after");

        Utils.initTime();
        mirrorReverse(root);
        printTree(root);
        Utils.timeConsuming();
    }

    private void mirrorReverse(Node node) {
        if (node == null) return;

        Node left = node.left;
        Node right = node.right;
        node.left = right;
        node.right = left;
        mirrorReverse(left);
        mirrorReverse(right);
    }

    private void printTree(Node root) {
        if (root == null) {
            System.out.println("input null");
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            sb.append(node.value).append(" ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        System.out.println(" |-- output >> " + sb.toString());
    }

}
