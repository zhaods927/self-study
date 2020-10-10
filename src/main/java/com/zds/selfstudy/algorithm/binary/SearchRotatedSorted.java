package com.zds.selfstudy.algorithm.binary;

/**
 * @program: self-study
 * @description: 搜索旋转排序数组
 * @author: zhaods
 * @create: 2020-10-03 14:03
 **/
public class SearchRotatedSorted {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(getSearchIndex(nums, target));
        target = 3;
        System.out.println(getSearchIndex(nums, target));
    }

    private static int getSearchIndex(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int medium;
        while (start + 1 < end) {
            medium = start + (end - start) / 2;
            if (nums[medium] == target) {
                return medium;
            }
            if (nums[medium] > nums[start]) {
                if (target <= nums[medium] && nums[start] <= target) {
                    end = medium;
                } else {
                    start = medium;
                }
            } else {
                if (target >= nums[medium] && nums[end] >= target) {
                    start = medium;
                } else {
                    end = medium;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
