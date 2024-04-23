package org.example.leetcode.list;

import java.util.Map;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(3,3);
        lruCache.put(1,1);
        lruCache.put(4,4);
        lruCache.put(2,2);

        for(Map.Entry<Integer, DLinkedNode> entry:lruCache.cache.entrySet()){
            System.out.printf("%d:%d%n", entry.getKey(), entry.getValue().value);
        }
    }
}
