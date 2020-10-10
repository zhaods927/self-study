package com.zds.selfstudy.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: self-study
 * @description: 二叉树的右视图
 * @author: zhaods
 * @create: 2020-10-06 20:23
 **/
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean findRight = false;
        while (!nodeQueue.isEmpty()) {
            findRight = false;
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodeQueue.poll();
                if (!findRight) {
                    result.add(poll.val);
                    findRight = true;
                }
                assert poll != null;
                if (poll.right != null) {
                    nodeQueue.offer(poll.right);
                }
                if (poll.left != null) {
                    nodeQueue.offer(poll.left);
                }
            }
        }

        return result;
    }

}
