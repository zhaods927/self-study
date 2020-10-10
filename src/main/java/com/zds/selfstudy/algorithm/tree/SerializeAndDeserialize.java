package com.zds.selfstudy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: self-study
 * @description: 二叉树的序列化与反序列化
 * @author: zhaods
 * @create: 2020-10-06 19:29
 **/
public class SerializeAndDeserialize {

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        if (null == root) {
            return "{}";
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode treeNode = nodeList.get(i);
            if (null == treeNode) {
                continue;
            }
            nodeList.add(treeNode.left);
            nodeList.add(treeNode.right);
        }
        while (nodeList.get(nodeList.size() - 1) == null) {
            nodeList.remove(nodeList.size() - 1);
        }
        StringBuilder res = new StringBuilder("{");
        res.append(nodeList.get(0).val);
        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode treeNode = nodeList.get(i);
            if (null == treeNode) {
                res.append(", #");
            } else {
                res.append(", ");
                res.append(treeNode.val);
            }
        }
        res.append("}");

        return res.toString();
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if (null == data || "{}".equals(data)) {
            return null;
        }
        String[] datas = data.substring(1, data.length() - 1).split(", ");
        boolean isLeft = true;
        List<TreeNode> nodeList = new ArrayList<>();
        TreeNode treeNode = new TreeNode(Integer.parseInt(datas[0]));
        nodeList.add(treeNode);
        int index = 0;
        for (int i = 1; i < datas.length; i++) {
            String data1 = datas[i];
            if (!"#".equals(data1)) {
                TreeNode treeNode1 = new TreeNode(Integer.parseInt(data1));
                if (isLeft) {
                    nodeList.get(index).left = treeNode1;
                } else {
                    nodeList.get(index).right = treeNode1;
                }
                nodeList.add(treeNode1);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }

        return nodeList.get(0);
    }
}
