package com.zds.selfstudy.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @program: self-study
 * @description: 数组中的第K个最大元素
 * @author: zhaods
 * @create: 2020-10-07 10:55
 **/
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargestIndexByHeap(nums, k));
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println(findKthLargestIndexByHeap(nums, k));
    }

    /**
     * 堆
     */
    public static int findKthLargestIndexByHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
       /* PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });*/
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k
                , (num1, num2) -> num2 - num1);

        for (int num : nums) {
            maxHeap.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    /**
     * 快速排序 最佳
     */
    public static int findKthLargestIndexByQuickSort(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }

        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSort(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (k <= right) {
            quickSort(nums, start, right, k);
        }
        if (k >= left) {
            quickSort(nums, left, end, k);
        }

        return nums[k];
    }
}
