package com.zds.selfstudy.algorithm.tree;

/**
 * @program: self-study
 * @description: Definition for a binary tree node.
 * @author: zhaods
 * @create: 2020-10-05 19:49
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
