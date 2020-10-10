package com.zds.selfstudy.algorithm.stack;

import java.util.Stack;

/**
 * @program: self-study
 * @description: 有效的括号
 * @author: zhaods
 * @create: 2020-10-02 17:07
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{{[({[]]})]}}"));
    }

    public static boolean isValid(String str) {
        if (null == str || str.length() == 0) {
            return true;
        }
       Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            }
            if (')' == c) {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (']' == c) {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if ('}' == c) {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
