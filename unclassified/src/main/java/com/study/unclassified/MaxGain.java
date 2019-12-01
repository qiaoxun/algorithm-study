package com.study.unclassified;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxGain {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            max = max > root.val ? max : root.val;
            return root.val;
        }

        int leftMax = root.left == null ? 0 : maxPathSum(root.left);
        int rightMax = root.right == null ? 0 : maxPathSum(root.right);

        int priceNewPrice = root.val + leftMax + rightMax;

        max = max > priceNewPrice ? max : priceNewPrice;

        return root.val + (leftMax > rightMax ? leftMax : rightMax);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}