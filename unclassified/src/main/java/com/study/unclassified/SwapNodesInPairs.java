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
//        node3.next = node4;

        ListNode head = swapPairs(node1);
        while (null != head) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preNode = dummy;

        while (null != head && null != head.next) {
            // swap
            ListNode secondNode = head.next;
            head.next = secondNode.next;
            secondNode.next = head;

            preNode.next = secondNode;
            preNode = head;
            head = head.next;
        }

        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {

        if (null == head || null == head.next)
            return head;

        ListNode next = head.next;
        ListNode temp = next.next;
        head.next = temp;
        next.next = head;
        head.next = swapPairs(temp);
        return next;
    }

    public ListNode swapPairs1(ListNode head) {

        return swapNode(head, null);
    }

    public ListNode swapNode(ListNode nodeToSwap, ListNode preNode) {
        ListNode nodeToReturn = nodeToSwap;
        ListNode nextToSwap;

        if (null != nodeToSwap && null != nodeToSwap.next) {
            ListNode nextNode = nodeToSwap.next;
            nextToSwap = nextNode.next;
            nodeToSwap.next = nextToSwap;
            nextNode.next = nodeToSwap;
            nodeToReturn = nextNode;
            if (null != preNode) {
                preNode.next = nextNode;
            }
            swapNode(nextToSwap, nodeToSwap);
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
