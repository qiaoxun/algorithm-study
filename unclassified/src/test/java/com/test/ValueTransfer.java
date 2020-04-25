package com.test;

import org.junit.Test;

public class ValueTransfer {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        System.out.println(node.val);
        changeRef(node);
        System.out.println(node.val);
    }

    private void changeRef(ListNode node) {
        node = new ListNode(2);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
