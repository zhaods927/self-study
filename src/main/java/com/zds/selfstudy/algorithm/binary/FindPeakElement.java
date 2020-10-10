package com.zds.selfstudy.algorithm.binary;

/**
 * @program: self-study
 * @description: 寻找峰值
 * @author: zhaods
 * @create: 2020-10-03 14:50
 **/
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElementIndex(nums)); // 2
        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElementIndex(nums)); // 1 or 5

    }

    private static int findPeakElementIndex(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int medium;
        while (start + 1 < end) {
            medium = start + (end - start) / 2;
            if (nums[medium] < nums[medium - 1]) {
                end = medium;
            } else if (nums[medium] < nums[medium + 1]) {
                start = medium;
            } else {
                return medium;
            }
        }

        return nums[start] > nums[end] ? start : end;
    }
}
