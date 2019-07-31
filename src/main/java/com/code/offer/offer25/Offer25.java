package com.code.offer.offer25;

import com.code.offer.Utils;
import com.code.offer.bean.Node;

import java.util.ArrayList;
import java.util.List;

public class Offer25 {

    /*
     * 二叉树中和为某一值的路径(其实就是深度优先打印，判断条件是和)
     *
     * 注：这个版本和 offer 中不一样，只要满足条件就能打印出来，不是非要最后节点是叶子
     *
     * 如果要和书中一致，只需增加判断当前节点是不是叶子节点即可
     *
     */
    public static void main(String[] args) {
        Offer25 test = new Offer25();

        Node tree = test.createTree();

        test.findPath(tree, 7);
        test.findPath(tree, 10);
        test.findPath(tree, 15);
        test.findPath(tree, 22);
    }

    private List<Node> list = new ArrayList<>();
    private int pathCount = 0;

    private void findPath(Node root, int target) {
        if (root == null) {
            System.out.println("input error");
            return;
        }
        pathCount = 0;
        System.out.println("input >> find sum: " + target);
        Utils.initTime();
        next(root, 0, target);
        Utils.timeConsuming();
        System.out.println(" |-- " + (pathCount > 0 ? "path count = " + pathCount : "path no found."));
        list.clear();
    }

    private void next(Node node, int currentSum, int target) {
        if (node == null) {
            return;
        }

        currentSum += node.value;
        list.add(node);
        if (currentSum == target) {
            print();
        } else if (currentSum < target) {
            if (node.left != null) {
                next(node.left, currentSum, target);
                list.remove(list.size() - 1);
            }
            if (node.right != null) {
                next(node.right, currentSum, target);
                list.remove(list.size() - 1);
            }
        }
    }

    private void print() {
        pathCount++;
        System.out.print(" |-- output >> find: ");
        StringBuilder sb = new StringBuilder();
        for (Node n : list) {
            sb.append(n.value).append(" ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        System.out.println(sb.toString());
    }

    private Node createTree() {
        Node root = new Node(10);

        Node left = new Node(5);
        left.left = new Node(4);
        left.right = new Node(7);

        root.left = left;
        root.right = new Node(12);

        return root;
    }
}
