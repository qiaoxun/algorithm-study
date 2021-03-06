package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

//        System.out.println(Arrays.toString(recur(node1, 0, 1)));
        ListNode head = removeNthFromEnd(node1, 2);
//        ListNode head = removeNthFromEnd_Array_Solution(node1, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int[] result = recur(head, n, 1);
        if (n == result[1]) {
            return head.next;
        }
        return head;
    }

    public int[] recur(ListNode node, int n, int size) {
        if (null == node) {
            return new int[]{n, size};
        }
        int currentSize = size;
        if (node.next != null) {
            size = size + 1;
            currentSize = size;
        } else {
            return new int[]{n, size};
        }
        int[] result = recur(node.next, n, size);
        int finalSize = result[1];
        if (n == finalSize - currentSize + 1) {
            node.next = node.next.next;
        }
        return result;
    }

    /**
     * array solution
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_Array_Solution(ListNode head, int n) {
        if (head == null)
            return null;

        if (head.next == null) {
            if (n == 0) {
                return head;
            }
            return null;
        }

        List<ListNode> listNodes = new ArrayList<>();
        ListNode node = head;
        while (null != node) {
            listNodes.add(node);
            node = node.next;
        }
        if (n < 0 || n > listNodes.size()) {
            return null;
        }
        int currentPos = listNodes.size() - n;
        if (currentPos == 0) {
            return head.next;
        }
        ListNode preNode = listNodes.get(currentPos - 1);
        if (currentPos < listNodes.size() - 1) {
            ListNode nextNode = listNodes.get(currentPos + 1);
            preNode.next = nextNode;
        } else {
            preNode.next = null;
        }
        return listNodes.get(0);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
