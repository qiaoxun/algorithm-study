package com.study.unclassified;

import org.junit.Test;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    @Test
    public void test() {
        int[] arr1 = { 9 };
//        int[] arr2 = { 1, 9};
        int[] arr2 = { 1, 9, 9, 9, 9, 9, 9, 9, 9, 9 };

        ListNode dummy1 = new ListNode(0);
        ListNode dummy1Head = null;

        ListNode dummy2 = new ListNode(0);
        ListNode dummy2Head = null;

        for (int i = 0; i < arr1.length; i++) {
            ListNode node = new ListNode(arr1[i]);
            if (i == 0) {
                dummy1Head = node;
            }
            dummy1.next = node;
            dummy1 = node;
        }

        for (int i = 0; i < arr2.length; i++) {
            ListNode node = new ListNode(arr2[i]);
            if (i == 0) {
                dummy2Head = node;
            }
            dummy2.next = node;
            dummy2 = node;
        }

        ListNode listNode = addTwoNumbers1(dummy1Head, dummy2Head);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    /**
     * 如果数字过大，大于 Integer.MAX_VALUE 会出错
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = getReverseSum(l1);
        int sum2 = getReverseSum(l2);
        int total = sum1 + sum2;

        ListNode firstNode = null;
        ListNode preNode = null;

        if (total == 0) {
            return new ListNode(0);
        }

        while (total > 0) {
            int digit = total % 10;
            ListNode node = new ListNode(digit);
            if (preNode == null) {
                preNode = node;
                firstNode = node;
            } else {
                preNode.next = node;
                preNode = node;
            }
            total = total / 10;
        }
        return firstNode;
    }

    private int getReverseSum(ListNode list) {
        int sum = 0;
        int i = 1;
        while(list != null) {
            sum += (i * list.val);
            i *= 10;
            list = list.next;
        }
        return sum;
    }

    // --------------------------------------- - - - -- - -- - - -- - - -- - - - -- -- - ----  - - - --

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode currentNode = new ListNode(0);

        int carry = 0;

        while (l1 != null || l2 != null) {
            int val = 0;
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            if (sum > 9) {
                val = sum % 10;
                carry = 1;
            } else {
                val = sum;
                carry = 0;
            }

            ListNode listNode = new ListNode(val);

            if (dummyNode.next == null) {
                dummyNode.next = listNode;
            }
            currentNode.next = listNode;
            currentNode = listNode;

            l1 = (l1 == null || l1.next == null) ? null : l1.next;
            l2 = (l2 == null || l2.next == null) ? null : l2.next;
        }

        if (carry == 1) {
            currentNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

