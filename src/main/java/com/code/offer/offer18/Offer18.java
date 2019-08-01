package com.code.offer.offer18;

import com.code.offer.Utils;
import com.code.offer.bean.Node;

public class Offer18 {

    /*
     * 树的子结构
     *
     * 输入两棵树A、B，判断B是不是A树的一部分
     *
     * 先找相同的根节点，在比较左右子树部分
     */
    public static void main(String[] args) {
        Offer18 test = new Offer18();

        Node treeA = Utils.createTree();

        // 14 12 16
        Node treeB = new Node(14);
        treeB.left = new Node(12);
        treeB.right = new Node(16);

        boolean b = test.hasSubTree(treeA, treeB);
        System.out.println(" |-- output >> hasSubTree? " + b);

        b = test.hasSubTree(treeA, new Node(20));
        System.out.println(" |-- output >> hasSubTree? " + b);

        //14 12 10
        Node treeC = new Node(14);
        treeC.left = new Node(12).left = new Node(10);
        b = test.hasSubTree(treeA, treeC);
        System.out.println(" |-- output >> hasSubTree? " + b);

        Node treeD = new Node(14);
        treeD.left = new Node(12);
        b = test.hasSubTree(treeA, treeD);
        System.out.println(" |-- output >> hasSubTree? " + b);

    }

    private boolean hasSubTree(Node treeA, Node treeB) {

        boolean result = false;

        if (treeA != null && treeB != null) {

            if (treeA.value == treeB.value) {
                result = doseTree1HaveTree2(treeA, treeB);
            }
            if (!result) {
                result = hasSubTree(treeA.left, treeB);
            }
            if (!result) {
                result = hasSubTree(treeA.right, treeB);
            }
        }

        return result;
    }

    private boolean doseTree1HaveTree2(Node a, Node b) {
        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }

        if (a.value != b.value) {
            return false;
        }
        boolean resultA = doseTree1HaveTree2(a.left, b.left);
        boolean resultB = doseTree1HaveTree2(a.right, b.right);
        return resultA && resultB;
    }

}
