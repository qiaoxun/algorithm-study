package com.study.unclassified;

import org.junit.Test;

import java.util.Stack;
import java.util.TreeMap;

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
        middleOrderRecursion(node);
        System.out.println("------------");
        middleOrderStack(node);
    }

    public void middleOrderStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }

    }

    public void middleOrderRecursion(TreeNode node) {
        if (node != null) {
            middleOrderRecursion(node.left);
            System.out.println(node.val);
            middleOrderRecursion(node.right);
        }
    }

    @Test
    public void testPostOrder() {
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
        postOrderRecursion(node);
        System.out.println("============");
    }

    public void postOrderRecursion(TreeNode node) {
        if (null != node) {
            postOrderRecursion(node.left);
            postOrderRecursion(node.right);
            System.out.println(node.val);
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
