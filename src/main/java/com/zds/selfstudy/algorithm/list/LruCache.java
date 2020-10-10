package com.zds.selfstudy.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: self-study
 * @description: Least Recently Used
 * @author: zhaods
 * @create: 2020-10-02 16:10
 **/
public class LruCache {
    private final int capacity;
    private final Map<Integer, CacheNode> valNodeMap = new HashMap<>();
    private final CacheNode head = new CacheNode(-1, -1);
    private final CacheNode tail = new CacheNode(-1, -1);

    public LruCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!valNodeMap.containsKey(key)) {
            return -1;
        }
        CacheNode current = valNodeMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return valNodeMap.get(key).value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            valNodeMap.get(key).value = value;
            return;
        }

        if (valNodeMap.size() == capacity) {
            valNodeMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        CacheNode insert = new CacheNode(key, value);
        valNodeMap.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(CacheNode current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
