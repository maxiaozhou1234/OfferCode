package com.code.offer.bean;

import java.util.List;

/**
 * 普通树
 */
public class NormalTreeNode {

    public List<NormalTreeNode> children;
    public int value;

    public NormalTreeNode(int value) {
        this.value = value;
    }
}
