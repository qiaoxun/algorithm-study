package com.study.unclassified;

import org.junit.Test;

import java.util.Stack;

public class BinaryTreeTraversal {

    @Test
    public void testPreOrderStack() {
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
        preOrderRecursion(node);
    }

    public void preOrderStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while (null != node && !stack.isEmpty()) {
            System.out.println(node.val);
            while (null != node) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop().right;
            }
        }
    }

    @Test
    public void testPreOrderRecursion() {
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
        preOrderRecursion(node);
    }

    public void preOrderRecursion(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrderRecursion(node.left);
            preOrderRecursion(node.right);
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
