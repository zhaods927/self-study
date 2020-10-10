package com.zds.selfstudy.algorithm.tree;


import java.util.*;

/**
 * @program: self-study
 * @description: 二叉树前序遍历
 * @author: zhaods
 * @create: 2020-10-05 19:50
 **/
public class PreOrderTraversal {

    /**
     * 1.递归：
     * 前序：
     * 先打印本身节点，
     * 然后打印左子树，
     * 最后打印右子树。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalByRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        List<Integer> left = this.preorderTraversalByRecursion(root.left);
        List<Integer> right = this.preorderTraversalByRecursion(root.right);

        // 本身
        result.add(root.val);
        // 左 （本-左-右）
        result.addAll(left);
        // 右 （本-左-右）
        result.addAll(right);

        return result;
    }

    /**
     * 2.非递归：
     * 前序：
     * 先打印本身节点，
     * 然后打印左子树，
     * 最后打印右子树。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        // 栈是先进后出 前序是先左后右因此倒序插入
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodePool = new ArrayList<>();
        if (root == null) {
            return nodePool;
        }
        traverse(root, nodePool, 0);
        return nodePool;
    }

    private void traverse(TreeNode root, List<List<Integer>> nodePool, int level) {
        if (root == null) {
            return;
        }
        if (nodePool.size() - 1 < level) {
            nodePool.add(new ArrayList<>());
        }
        nodePool.get(level).add(root.val);
        traverse(root.left, nodePool, level + 1);
        traverse(root.right, nodePool, level + 1);
    }

    public List<List<Integer>> levelOrderByQueue(TreeNode root) {
        // 1、判断二叉树不为空的操作
        if (root == null) {
            return new ArrayList<>();
        }
        // 2、先构建了一个双层列表，用于存储结果
        List<List<Integer>> result = new ArrayList<>();
        // 3、再创建一个队列，用于存储每一层的节点，然后再pop
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 在队列非空时处理
        while (!queue.isEmpty()) {
            // 4、创建一个单层列表，用来存储每一层的结果
            List<Integer> middle = new ArrayList<>();
            // 5、开始遍历队列输出
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                middle.add(node.val);
                // 6、判断节点的左右子节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(middle);
        }
        return result;
    }
}
