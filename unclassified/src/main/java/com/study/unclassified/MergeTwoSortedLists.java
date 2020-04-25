package com.study.unclassified;

import org.junit.Test;

public class MergeTwoSortedLists {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node4;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        node21.next = node22;
        node22.next = node24;

        ListNode result = mergeTwoLists(null, node21);

        while (null != result) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode first = null;
        while (l1 != null) {
            if (null == l2) {
                if (null != node) {
                    node.next = l1;
                } else {
                    node = l1;
                    first = node;
                }
                break;
            }
            if (l1.val < l2.val) {
                if (null == node) {
                    node = l1;
                    first = l1;
                } else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
            } else {
                if (null == node) {
                    node = l2;
                    first = l2;
                } else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
            }
        }
        if (null != l2) {
            if (null != node) {
                node.next = l2;
            } else {
                node = l2;
                first = node;
            }
        }
        return first;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
