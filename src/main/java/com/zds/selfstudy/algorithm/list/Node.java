package com.zds.selfstudy.algorithm.list;

/**
 * @program: self-study
 * @description: Definition for a Node.
 * @author: zhaods
 * @create: 2020-10-02 15:42
 **/
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
