package com.zds.selfstudy.algorithm.binary;

/**
 * @program: self-study
 * @description: 二分法模板
 * @author: zhaods
 * @create: 2020-10-03 08:37
 **/
public class BinarySearchTemplate {

    public static void main(String[] args) {
        int[] numbers = {1, 4, 5, 0, 9, 10, 20, 26, 39, 45};
        System.out.println(getIndex(numbers, 20));
    }

    private static Integer getIndex(int[] numbers, int target) {
        if (null == numbers || numbers.length == 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        int medium;
        while (start + 1 < end) {
            medium = start + (end - start) / 2;
            if (numbers[medium] == target) {
                return medium;
            } else if (numbers[medium] > target) {
                end = medium;
            } else {
                start = medium;
            }
        }
        if (numbers[start] == target) {
            return start;
        }
        if (numbers[end] == target) {
            return end;
        }

        return -1;
    }
}
