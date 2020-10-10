package com.zds.selfstudy.algorithm.list;

/**
 * @program: self-study
 * @description: Definition for a CacheNode.
 * @author: zhaods
 * @create: 2020-10-02 16:08
 **/
public class CacheNode {
    CacheNode prev;
    CacheNode next;
    int key;
    int value;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
