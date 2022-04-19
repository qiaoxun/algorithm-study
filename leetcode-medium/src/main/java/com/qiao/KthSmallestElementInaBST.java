package com.qiao;

public class KthSmallestElementInaBST {

    private int count = 0;
    private int value = 0;

    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return value;
    }

    private void traversal(TreeNode node, int k) {
        if (node == null) return;

        traversal(node.left, k);
        count ++;
        if (k == count) {
            value = node.val;
            return;
        }
        traversal(node.right, k);
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
