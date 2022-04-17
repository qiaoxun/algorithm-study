package com.qiao;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class TrimBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
//        root.left = left;

        TrimBinarySearchTree t = new TrimBinarySearchTree();
        t.trimBST(root, 1, 2);

        System.out.println(root);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        if (root.val < low) {
            root = root.right;
            return trimBST(root, low, high);
        }

        if (root.val > high) {
            root = root.left;
            return trimBST(root, low, high);
        }

        findLowerThenLowAndTrim(root, root.left, low);
        findHigherThenHighAndTrim(root, root.right, high);

        return root;
    }

    private void findLowerThenLowAndTrim(TreeNode parent, TreeNode node, int low) {
        if (parent == null || node == null) {
            return;
        }
        if (node.val >= low) {
            TreeNode childNode = node.left;
            findLowerThenLowAndTrim(node, childNode, low);
        } else {
            parent.left = node.right;
            findLowerThenLowAndTrim(parent, parent.left, low);
        }
    }

    private void findHigherThenHighAndTrim(TreeNode parent, TreeNode node, int high) {
        if (parent == null || node == null) {
            return;
        }
        if (node.val <= high) {
            TreeNode childNode = node.right;
            findHigherThenHighAndTrim(node, childNode, high);
        } else {
            parent.right = node.left;
            findHigherThenHighAndTrim(parent, parent.right, high);
        }
    }


    static class TreeNode {
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
