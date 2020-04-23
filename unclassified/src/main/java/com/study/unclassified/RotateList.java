package com.study.unclassified;

import org.junit.Test;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode head = rotateRight(node1, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        int size = getListSize(head);
        k = k % size;
        for (int i = 0; i < k; i++) {
            head = rotate(head);
        }
        return head;
    }

    private int getListSize(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (null != node) {
            size = size + 1;
            node = node.next;
        }
        return size;
    }

    /**
     * Time Limit Exceeded
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight_Time_Limit_Exceeded(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        for (int i = 0; i < k; i++) {
            head = rotate(head);
        }
        return head;
    }

    public ListNode rotate(ListNode head) {
        ListNode node = head;
        ListNode lastSecond = null;
        while (null != node.next) {
            if (node.next.next == null) {
                lastSecond = node;
            }
            node = node.next;
        }
        lastSecond.next = null;
        node.next = head;
        return node;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
