package com.zds.selfstudy.algorithm.tree;

/**
 * @program: self-study
 * @description: 二叉树的最近公共祖先
 * @author: zhaods
 * @create: 2020-10-06 20:43
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}
