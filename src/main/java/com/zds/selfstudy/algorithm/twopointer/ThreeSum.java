package com.zds.selfstudy.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: self-study
 * @description: 三数之和
 * @author: zhaods
 * @create: 2020-10-03 17:46
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(getThreeSumNum(nums));
    }

    /**
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 使得 a，b，c ，使得 a + b + c = 0
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    private static List<List<Integer>> getThreeSumNum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    left++;
                    right--;
                    result.add(list);
                    while (left < right && (nums[left] == nums[left - 1])) {
                        left++;
                    }
                    while (left < right && (nums[right] == nums[right + 1])) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
