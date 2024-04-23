package org.example.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> cache = null;
    int capacity;

    public LRUCache(int capacity) {

        cache = new HashMap<>(capacity);
        this.capacity = capacity;

        head = new DLinkedNode(-1,-1);
        head.prev = null;

        tail = new DLinkedNode(-1,-1);
        tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public int put(int key, int value) {

        DLinkedNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            if (capacity == cache.size()) {
                cache.remove(key);
                removeLastNode();
            }
            cache.put(key, newNode);
            addToHead(newNode);
            return newNode.value;
        }
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    void removeLastNode(){
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
    }

    void addToHead(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev = head;
    }

    void moveToHead(DLinkedNode node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;

        addToHead(node);
    }
}

class DLinkedNode {

    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
