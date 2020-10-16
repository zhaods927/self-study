package com.zds.selfstudy.algorithm.hash;

import java.util.*;

/**
 * @program: self-study
 * @description: 克隆图
 * @author: zhaods
 * @create: 2020-10-10 15:27
 **/
public class CloneGraph {


    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        ArrayList<Node> nodes = getNodes(node);
        Map<Node, Node> mapping = new HashMap<>();
        // copy nodes
        for (Node n : nodes) {
            mapping.put(n, new Node(n.val));
        }
        // copy neighbors
        for (Node n : nodes) {
            Node newNode = mapping.get(n);
            for (Node neighbor : n.neighbors) {
                Node newNeighbors = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbors);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            for (Node neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<>(set);
    }

}
