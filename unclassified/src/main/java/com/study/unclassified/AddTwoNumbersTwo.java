package com.study.unclassified;

import org.junit.Test;

import java.util.*;

public class AddTwoNumbersTwo {

    @Test
    public void test() {
//        int[] arr1 = { 9 };
        int[] arr1 = { 7, 2, 4, 3 };
//        int[] arr2 = { 1, 9};
//        int[] arr2 = { 1, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        int[] arr2 = { 5, 6, 4 };

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

        ListNode listNode = addTwoNumbers(dummy1Head, dummy2Head);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    /**
     * Using Stack
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;

        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();


        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pop();
            int value2 = stack2.isEmpty() ? 0 : stack2.pop();

            int result = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            ListNode cur = new ListNode(result);

            cur.next = resultNode;
            resultNode = cur;

        }

        return resultNode;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode dummyResultNode = resultNode;
        int carry = 0;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while(l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
                list1.add(value1);
            } else {
                list1.add(0, 0);
            }

            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
                list2.add(value2);
            } else {
                list2.add(0, 0);
            }
        }

        int length = list1.size();

        List<Integer> resultList = new ArrayList<>();

        for (int i = length - 1; i >= 0; i--) {
            int value1 = list1.get(i);
            int value2 = list2.get(i);
            int result = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            resultList.add(0, result);
        }

        if (carry > 0) {
            resultList.add(0, carry);
        }

        for (int i = 0; i < resultList.size(); i++) {
            dummyResultNode.next = new ListNode(resultList.get(i));
            dummyResultNode = dummyResultNode.next;
        }

        return resultNode.next;
    }

    /**
     * this solution is wrong
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyNode1 = l1;
        ListNode dummyNode2 = l2;
        ListNode resultNode = new ListNode(0);
        ListNode dummyResultNode = resultNode;
        int carry = 0;

        while(dummyNode1 != null || dummyNode2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (dummyNode1 != null) {
                value1 = dummyNode1.val;
                dummyNode1 = dummyNode1.next;
            }

            if (dummyNode2 != null) {
                value2 = dummyNode2.val;
                dummyNode2 = dummyNode2.next;
            }
            int result = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            dummyResultNode.next = new ListNode(result);
            dummyResultNode = dummyResultNode.next;
        }

        if (carry > 0) {
            dummyResultNode.next = new ListNode(carry);
        }

        return resultNode.next;
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}