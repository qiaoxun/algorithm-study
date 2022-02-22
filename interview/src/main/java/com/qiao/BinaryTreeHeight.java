package com.qiao;

/**
 * 4
 */
public class BinaryTreeHeight {

    public static void main(String[] args) {
        Node root = new Node();
        Node left = new Node();
        Node right = new Node();
        root.left = left;
        root.right = right;
        Node left1 = new Node();
        left.left = left1;
        Node left2 = new Node();
        left1.left = left2;
        Node left3 = new Node();
        right.left = left3;

        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
        // 4
        System.out.println(binaryTreeHeight.height(root));
    }

    public int height(Node node) {
        return calcHeight(node, 1);
    }

    private int calcHeight(Node node, int height) {
        if (node == null) {
            return height;
        }

        int leftHeight = height;
        int rightHeight = height;

        if (node.left != null) {
            leftHeight = calcHeight(node.left, height + 1);
        }

        if (node.right != null) {
            rightHeight = calcHeight(node.right, height + 1);
        }
        return leftHeight >  rightHeight ? leftHeight : rightHeight;
    }

}

class Node {
    public Node left;
    public Node right;
}
