package com.zds.selfstudy.algorithm.twopointer;

/**
 * @program: self-study
 * @description: 接雨水
 * @author: zhaods
 * @create: 2020-10-03 21:01
 **/
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(nums));
    }

    /**
     * 给定n个非负整数表示每个宽度为 1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */
    private static int trap(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int leftHeight = nums[left];
        int rightHeight = nums[right];
        int count = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                if (leftHeight > nums[left + 1]) {
                    count += leftHeight - nums[left + 1];
                } else {
                    leftHeight = nums[left + 1];
                }
                left++;
            } else {
                if (rightHeight > nums[right - 1]) {
                    count += rightHeight - nums[right - 1];
                } else {
                    rightHeight = nums[right - 1];
                }
                right--;
            }
        }

        return count;
    }

}
