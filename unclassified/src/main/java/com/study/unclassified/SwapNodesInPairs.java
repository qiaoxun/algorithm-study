package com.study.unclassified;

import org.junit.Test;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = swapPairs(node1);
        while (null != head) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode nodeToReturn = head;
        ListNode nextToSwap;

        if (null != head && null != head.next) {
            ListNode nextNode = head.next;
            nextToSwap = nextNode.next;
            head.next = nextToSwap;
            nextNode.next = head;
            nodeToReturn = nextNode;
            swapPairs(nextToSwap);
        }
        return nodeToReturn;
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
