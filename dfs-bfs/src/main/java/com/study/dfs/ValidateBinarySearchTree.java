package com.study.dfs;

import org.junit.Test;

public class ValidateBinarySearchTree {

    @Test
    public void test() {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(8);
        node.left = node1;
        node.right = node2;
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(isValidBST(node));
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        return isValid(root, root.val, 0);
    }

    /**
     *
     * @param node
     * @param val
     * @param direction -1 -> left, 1 -> right
     * @return
     */
    private boolean isValid(TreeNode node, int val, int direction) {
        boolean result = true;
        if (null != node.left) {
            if (direction > 0 && node.left.val <= val) {
                return false;
            }
            if (direction < 0 && node.left.val >= val) {
                return false;
            }

            if (node.val > node.left.val) {
                if (!isValid(node.left, node.val, -1)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (null != node.right) {
            if (direction > 0 && node.right.val <= val) {
                return false;
            }
            if (direction < 0 && node.right.val >= val) {
                return false;
            }

            if (node.val < node.right.val) {
                if (!isValid(node.right, node.val, 1)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return result;
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
