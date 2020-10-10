package com.zds.selfstudy.algorithm.list;

/**
 * @program: self-study
 * @description:
 * @author: zhaods
 * @create: 2020-10-02 13:20
 **/
public class ReverseLinkedList {

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1 -> 2 -> 3 -> 4 -> 5
        // prev = 1
        // current = 2;
        ListNode prev = head;
        ListNode current = head.next;
        // 1  2 -> 3 -> 4 -> 5
        // prev = 1
        // current = 2;
        prev.next = null;
        while (current != null) {
            // First time
          /*
          next = 3
          1  <- 2  3 -> 4 -> 5
          prev = 2
          current = 3
          */
            // Second time
          /*
          next = 4
          1  <- 2 <- 3  4 -> 5
          prev = 3
          current = 4
          */
            // third time
          /*
          next = 5
          1  <- 2 <- 3 <- 4 5
          prev = 4
          current = 5
          */
            // fourth time
          /*
          next = null
          1  <- 2 <- 3 <- 4 <-5
          prev = 5
          current = null
          */
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //exit
        //return prev = 5
        return prev;
    }

    /**
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        // nNode => prev;
        //postN => current
        for (int i = m; i < n; i++) {
            /*
             ListNode next = current.next;
             current.next = prev;
             prev = current;
             current = next;
             **/
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        mNode.next = postN;
        prevM.next = nNode;
        return dummy.next;
    }

}
