package com.study.unclassified;

import org.junit.Test;

public class BinaryTreeTraversal {

    @Test
    public void testPreOrder() {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.right = node5;
        preOrder(node);
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @Test
    public void testMiddleOrder() {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.right = node5;
//        node2.left = node3;
//        node2.right = node4;
        middleOrder(node);
    }

    public void middleOrder(TreeNode node) {
        if (node != null) {
            middleOrder(node.left);
            System.out.println(node.val);
            middleOrder(node.right);
        }
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
