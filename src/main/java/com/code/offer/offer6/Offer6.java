package com.code.offer.offer6;

import com.code.offer.bean.Node;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Offer6 {

    /*
     * 重建二叉树
     *
     * 输入前序序列和中序序列，重建二叉树
     */
    public static void main(String[] args) {

        Offer6 test = new Offer6();

        test.rebuildTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }

    private void rebuildTree(int[] front, int[] midst) {

        System.out.println("input front = " + Arrays.toString(front) + ", midst = " + Arrays.toString(midst));
        if (front == null || midst == null || front.length != midst.length) {
            System.out.println("input error,array is null or length is not same.");
            return;
        }

        Node node = rebuildTree(front, 0, midst, 0, midst.length - 1);
        printTreeByLevel(node);
    }

    private Node rebuildTree(int[] front, int startIndex, int[] midst, int start, int end) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return new Node(midst[start]);
        }

        Node node = new Node(front[startIndex]);
        int i = start;
        for (; i < end; i++) {
            if (midst[i] == front[startIndex]) {
                break;
            }
        }
        node.left = rebuildTree(front, startIndex + 1, midst, start, i - 1);
        node.right = rebuildTree(front, startIndex + (i - start + 1), midst, i + 1, end);

        return node;
    }

    private void printTreeByLevel(Node node) {
        if (node == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            sb.append(n.value).append(",");
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
        System.out.println(" |-- output >>" + sb.toString());
    }
}
