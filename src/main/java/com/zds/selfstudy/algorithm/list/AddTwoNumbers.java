package com.zds.selfstudy.algorithm.list;

/**
 * @program: self-study
 * @description:
 * @author: zhaods
 * @create: 2020-10-02 16:07
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            int number = l1.val + l2.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number % 10);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int number = l1.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number % 10);
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int number = l2.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number % 10);
            pre = pre.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return head.next;
    }
}
