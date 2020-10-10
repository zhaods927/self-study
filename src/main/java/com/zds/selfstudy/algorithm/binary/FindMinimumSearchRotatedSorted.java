package com.zds.selfstudy.algorithm.binary;

/**
 * @program: self-study
 * @description: 寻找旋转排序数组中的最小值
 * @author: zhaods
 * @create: 2020-10-03 14:20
 **/
public class FindMinimumSearchRotatedSorted {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMinNum(nums)); // 1
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMinNum(nums)); // 0

        nums = new int[]{4, 4, 5, 5, 6, 7, 1, 2,};
        System.out.println(findMinNum2(nums)); // 1
    }

    /**
     * 不重复数组 二分法
     *
     * @param nums
     * @return
     */
    private static int findMinNum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int medium;
        while (start + 1 < end) {
            medium = start + (end - start) / 2;
            if (nums[medium] >= nums[start]) {
                if (nums[end] <= nums[medium]) {
                    start = medium;
                } else {
                    end = medium;
                }
            } else {
                end = medium;
            }
        }

        return Math.min(nums[start], nums[end]);
    }

    /**
     * 重复数组 最小值比较法
     *
     * @param nums
     * @return
     */
    public static int findMinNum2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int min = nums[0];
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}
