package com.zds.selfstudy.algorithm.hash;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: self-study
 * @description: 和为K的子数组
 * @author: zhaods
 * @create: 2020-10-10 11:07
 **/
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 0, 5};
        int k = 5;
        System.out.println(subarraySum(nums, k));
        nums = new int[]{1, 1, 1};
        k = 2;
        System.out.println(subarraySum(nums, k));
    }

    private static int subarraySum(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        // nums = {1, 2, 3, 4,  0,  5}
        // nums = {1, 3, 6, 10, 10, 15}
        int result = 0;
        int temp;
        map.put(0, 1);
        for (int num : nums) {
            if (map.containsKey(num - k)) {
                result += map.get(num - k);
            }
            temp = map.containsKey(num) ? map.get(num) + 1 : 1;
            map.put(num, temp);
        }
        // map = 0:1, 1:1, 3:1, 6:1, 10:2, 15:1

        return result;
    }
}
