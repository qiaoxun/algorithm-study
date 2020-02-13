package com.studu.dp;

import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {

        return null;
    }

    private void putNode(TreeNode node, TreeNode newNode) {
        if (newNode.val > node.val) {
            if (node.right != null) {
                putNode(node.right, newNode);
            } else {
                node.right = newNode;
            }
        } else {
            if (node.left != null) {
                putNode(node.left, newNode);
            } else {
                node.left = newNode;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}