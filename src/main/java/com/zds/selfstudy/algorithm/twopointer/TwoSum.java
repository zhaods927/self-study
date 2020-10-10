package com.zds.selfstudy.algorithm.twopointer;

import java.util.Arrays;

/**
 * @program: self-study
 * @description: 两数之和
 * @author: zhaods
 * @create: 2020-10-03 17:18
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 9;
        System.out.println(Arrays.toString(getTwoSumIndex(nums, target)));
        System.out.println(getTwoSumCount(nums, target));
    }

    /**
     * p:示例:
     * 给定 nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], target = 9
     * 因为 nums[0] + nums[9] = 0 + 9 = 9
     * 所以返回 [0, 9]
     */
    private static int[] getTwoSumIndex(int[] nums, int target) {
        int[] result = {-1, -1};
        if (null == nums || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                result[0] = start;
                result[1] = end;
                break;
            }
        }

        return result;
    }

    /**
     * p:示例:
     * 给定 nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], target = 9
     * 因为 nums[0] + nums[9] = 0 + 9 = 9  nums[1] + nums[8] = 1 + 8 = 9 ...
     * 所以返回 5
     */
    private static int getTwoSumCount(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                end--;
                start++;
                count++;
            }
        }

        return count;
    }
}
