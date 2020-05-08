package com.study.dfs;

import org.junit.Test;

public class ValidateBinarySearchTree {

    @Test
    public void test() {
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
//        node4.right = node5;
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(isValidBST(node));
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        return isValid(root, null, null);
    }

    /**
     * @param node
     * @return
     */
    private boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (null == node) return true;

        if (null != lower && node.val <= lower) return false;
        if (null != upper && node.val >= upper) return false;

        if (!isValid(node.left, lower, node.val)) return false;
        if (!isValid(node.right, node.val, upper)) return false;

        return true;
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
