package com.zds.selfstudy.algorithm.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: self-study
 * @description: Definition for a Node.
 * @author: zhaods
 * @create: 2020-10-10 15:28
 **/
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}
