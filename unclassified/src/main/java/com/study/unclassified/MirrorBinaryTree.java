package com.study.unclassified;

import org.junit.Test;

public class MirrorBinaryTree {

    @Test
    public void test() {

    }

    public void mirror(Node node) {
        if (node.left != null && node.right != null) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        } else if (node.right == null) {
            node.right = node.left;
            node.left = null;
        } else {
            node.left = node.right;
            node.right = null;
        }

        if (node.left != null) {
            mirror(node.left);
        }
        if (node.right != null) {
            mirror(node.right);
        }
    }

    class Node {
        Node left;
        Node right;
        String name;
    }

}
