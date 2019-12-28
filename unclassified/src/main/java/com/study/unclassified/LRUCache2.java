package com.study.unclassified;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * head <--> first <--> second <--> third <--> ... <--> last <--> tail
 */
public class LRUCache2 {

    private Map<Integer, Node> map = new HashMap<>();
    private Node tail;
    private Node head;
    private int capacity;

    public LRUCache2(int capacity) {
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
        addHead(node);
    }

    public void addHead(Node node) {
        Node next = head.next;
        next.prev = node;
        node.next = next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        if (null == node) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private class Node {
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        Node next;
        Node prev;
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2( 2 /* capacity */ );
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));;
        System.out.println(cache.get(2));;
    }
}
