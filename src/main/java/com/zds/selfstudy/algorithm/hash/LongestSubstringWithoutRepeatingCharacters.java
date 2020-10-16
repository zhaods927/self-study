package com.zds.selfstudy.algorithm.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: self-study
 * @description: 无重复字符的最长子串
 * @author: zhaods
 * @create: 2020-10-12 12:02
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        // 示例 1:
        // 输入: "abcabcbb"
        // 输出: 3
        // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        // 示例 2:
        // 输入: "bbbbb"
        // 输出: 1
        // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));

        // 示例 3:
        // 输入: "pwwkew"
        // 输出: 3
        // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }

        return max;
    }

}
