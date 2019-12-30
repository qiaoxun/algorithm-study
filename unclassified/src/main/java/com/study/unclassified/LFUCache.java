package com.study.unclassified;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Map<Integer, Node> scoreMap = new TreeMap<>();
    private Node tail;
    private Node head;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        }
        removeNode(node);
        addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (null != node) {
            node.value = value;
            removeNode(node);
            addHead(node);
            return;
        }
        if (map.size() == capacity) {
            Node last = tail.prev;
            map.remove(last.key);
            removeNode(last);
        }
        node = new Node(key, value);
        map.put(key, node);
        scoreMap.put(node.key, node);
        addHead(node);
    }

    public void addHead(Node node) {
        Node next = head.next;
        next.prev = node;
        node.next = next;
        head.next = node;
        node.prev = head;
        node.freq++;
    }

    private void removeNode(Node node) {
        if (null == node) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static class Node implements Comparable<Node> {
        int key;
        int value;
        int freq;

        public Node(int freq) {
            this.freq = freq;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        Node next;
        Node prev;

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);

        TreeMap<String, Node> map = new TreeMap<>();
        map.put("node4", node4);
        map.put("node", node);
        map.put("node1", node1);
        map.put("node2", node2);
        map.put("node3", node3);

        System.out.println(map.pollLastEntry().getKey());
    }

}
