package com.zds.selfstudy.test;

import com.zds.selfstudy.algorithm.tree.TreeNode;

import java.util.Arrays;
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

        int[] array = {0, 4, 5, 45, 23, 7, 6, 7, 1, 10};
        int[] arr = new int[array.length];

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arr));
    }


}
