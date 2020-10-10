package com.zds.selfstudy.algorithm.list;

/**
 * @program: self-study
 * @description:
 * @author: zhaods
 * @create: 2020-10-02 15:43
 **/
public class CopyListWithRandomPointer {

    /**
     * 示例 1：
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * 示例 4：
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     *
     * @param head
     * @return
     */

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }

    public void copy(Node head) {
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
    }

    public void copyRandom(Node head) {
        Node node = head;
        while (node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    public Node split(Node head) {
        Node result = head.next;
        Node move = head.next;
        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
            if (move != null && move.next != null) {
                move.next = move.next.next;
                move = move.next;
            }
        }
        return result;
    }
}
