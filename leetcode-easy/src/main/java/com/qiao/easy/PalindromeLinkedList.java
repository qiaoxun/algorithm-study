package com.qiao.easy;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(p.isPalindrome(listNode1));
    }

    private ListNode currentNode;

    public boolean isPalindrome(ListNode head) {
        currentNode = head;
        return recursive(head);
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

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
