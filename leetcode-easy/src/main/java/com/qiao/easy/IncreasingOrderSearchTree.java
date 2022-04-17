package com.qiao.easy;

/**
 * https://leetcode.com/problems/increasing-order-search-tree
 */
public class IncreasingOrderSearchTree {

    private TreeNode newRoot = null;
    private TreeNode newCurrentNode = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(4);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;

        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        increasingOrderSearchTree.increasingBST(root);
        System.out.println(increasingOrderSearchTree.newRoot);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return newRoot;
        increasingBST(root.left);
        if (newRoot == null) {
            newRoot = root;
            newCurrentNode = root;
        } else {
            newCurrentNode.right = root;
            root.left = null;
            newCurrentNode = root;
        }
        increasingBST(root.right);
        return newRoot;
    }

    public void iteratorBST(TreeNode node) {
        if (node == null) return;
        iteratorBST(node.left);
        if (newRoot == null) {
            newRoot = node;
            newCurrentNode = node;
        } else {
            newCurrentNode.right = node;
            node.left = null;
            newCurrentNode = node;
        }
        System.out.println(node.val);
        iteratorBST(node.right);
    }



}
