package com.zds.selfstudy.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: self-study
 * @description: 二叉树中序遍历
 * @author: zhaods
 * @create: 2020-10-05 20:40
 **/
public class InOrderTraversal {

    /**
     * 1.递归：
     * 中序：
     * 先打印左子树，
     * 在打印本身节点，
     * 最后打印右子树。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }
        List<Integer> left = this.inorderTraversalByRecursion(root.left);
        List<Integer> right = this.inorderTraversalByRecursion(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    /**
     * 2.非递归：
     * 中序：
     * 先打印左子树，
     * 在打印本身节点，
     * 最后打印右子树。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}
