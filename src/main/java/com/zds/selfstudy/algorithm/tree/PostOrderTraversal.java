package com.zds.selfstudy.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: self-study
 * @description: 二叉树后序遍历
 * @author: zhaods
 * @create: 2020-10-05 21:01
 **/
public class PostOrderTraversal {

    /**
     * 1.递归：
     * 后序：
     * 先打印左子树，
     * 再打印右子树，
     * 最后打印本身节点。
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalByRecursion(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        List<Integer> left = this.postorderTraversalByRecursion(root.left);
        List<Integer> right = this.postorderTraversalByRecursion(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);

        /*
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.offerFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        */

        return result;
    }

    public List<Integer> postorderByTwoStack(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            if (temp != null) {
                stack2.push(temp.val);
                stack1.push(temp.left);
                stack1.push(temp.right);
            }
        }
        List<Integer> results = new ArrayList<Integer>();
        while (!stack2.isEmpty()) {
            results.add(stack2.pop());
        }
        return results;
    }

    /**
     * 2.非递归：
     * 后序：
     * 先打印左子树，
     * 再打印右子树，
     * 最后打印本身节点。
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.right == null && peek.left == null) {
                result.add(stack.pop().val);
            }
            if (peek.right != null) {
                stack.push(peek.right);
                peek.right = null;
            }
            if (peek.left != null) {
                stack.push(peek.left);
                peek.left = null;
            }
        }

        return result;
    }

    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // previously traversed node
        TreeNode prev = null;
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            // traverse down the tree
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
                // traverse up the tree from the left
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }

    public static List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        // 用来记录上一节点
        TreeNode p = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            // 后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。
            // 所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
            // 如果是从右边再返回根结点，应该回到上层。
            // 主要就是判断出来的是不是右子树，是的话就可以把根节点=加入到list了
            if (cur.right == null || cur.right == p) {
                list.add(cur.val);
                stack.pop();
                p = cur;
                cur = null;
            } else {
                cur = cur.right;
            }

        }
        return list;
    }
}
