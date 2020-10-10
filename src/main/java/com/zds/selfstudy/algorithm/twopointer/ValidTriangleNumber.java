package com.zds.selfstudy.algorithm.twopointer;

import java.util.Arrays;

/**
 * @program: self-study
 * @description: 有效三角形的个数
 * @author: zhaods
 * @create: 2020-10-03 20:12
 **/
public class ValidTriangleNumber {

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }

    /**
     * 给定一个包含非负整数的数组,统计其中可以组成三角形三条边的三元组个数。
     * p:
     * 输入: [2,2,3,4]
     * 输出: 3
     * 解释:
     * 有效的组合是:
     * 2,3,4 (使用第一个 2)
     * 2,3,4 (使用第二个 2)
     * 2,2,3
     */
    public static int triangleNumber(int[] nums) {
        if (null == nums || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    count += (end - start);
                    end--;
                } else {
                    start++;
                }
            }

        }
        return count;
    }
}
