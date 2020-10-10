package com.zds.selfstudy.algorithm.queue;

import java.util.Stack;

/**
 * @program: self-study
 * @description: 通过栈实现队列
 * @author: zhaods
 * @create: 2020-10-02 20:28
 **/
public class ImplQueueByStack {

    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    /**
     * Initialize your data structure here.
     */
    public ImplQueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (this.empty()) {
            return -1;
        }

        this.fromStack1ToStack2();

        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (this.empty()) {
            return -1;
        }

        this.fromStack1ToStack2();

        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void fromStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
