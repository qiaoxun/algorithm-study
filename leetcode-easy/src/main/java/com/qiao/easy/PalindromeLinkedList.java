package com.qiao.easy;

import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(p.isPalindrome(listNode1));
    }

    private ListNode currentNode;

    public boolean isPalindrome(ListNode head) {
        currentNode = head;
        return slowQuickSolution(head);
//        return recursive(head);
//        return false;
    }

    public boolean recursive(ListNode node) {
        if (node != null) {
            boolean result = recursive(node.next);
            if (!result) {
                return false;
            }
            if (currentNode.val == node.val) {
                currentNode = currentNode.next;
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean slowQuickSolution(ListNode head) {
        ListNode quickNode = head;
        ListNode slowNode = head;

        while (quickNode != null && quickNode.next != null && quickNode.next.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }

        ListNode lastNode = reverseSecondHalfPart(slowNode.next);
        ListNode firstNode = head;

        while (null != firstNode && null != lastNode) {
            if (firstNode.val == lastNode.val) {
                firstNode = firstNode.next;
                lastNode = lastNode.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseSecondHalfPart(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (null != current) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
