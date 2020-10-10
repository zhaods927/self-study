package com.zds.selfstudy.algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: self-study
 * @description: 从数据流中找中位数
 * @author: zhaods
 * @create: 2020-10-09 13:44
 **/
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new FindMedianFromDataStream().getMedian(nums)));
        nums = new int[]{4, 5, 1, 3, 2, 6, 0};
        System.out.println(Arrays.toString(new FindMedianFromDataStream().getMedian(nums)));
    }


    public int[] getMedian(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int count = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(count, (num1, num2) -> num2 - num1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count);
        int[] result = new int[count];
        int number = nums[0];
        result[0] = number;
        for (int i = 1; i < count; i++) {
            int num = nums[i];
            if (num > number) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }

            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                if (maxHeap.size() - minHeap.size() == 1
                        && maxHeap.peek() < number) {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }

            result[i] = number;
        }

        return result;
    }
}
