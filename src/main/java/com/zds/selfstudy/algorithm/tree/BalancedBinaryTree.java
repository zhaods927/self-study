package com.zds.selfstudy.algorithm.tree;

/**
 * @program: self-study
 * @description: 平衡二叉树
 * @author: zhaods
 * @create: 2020-10-07 09:42
 **/
public class BalancedBinaryTree {

    /**
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        return maxTree(root) != -1;
    }

    private int maxTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxTree(root.left);
        int right = maxTree(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
