package com.zds.selfstudy.test;

import com.zds.selfstudy.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: self-study
 * @description:
 * @author: zhaods
 * @create: 2020-10-03 13:49
 **/
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }
    }


}
