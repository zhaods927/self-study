package com.zds.selfstudy.algorithm.sort;

import java.util.Arrays;

/**
 * @program: self-study
 * @description: 快速排序
 * @author: zhaods
 * @create: 2020-10-03 21:28
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 45, 23, 7, 6, 7, 1, 10};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }

        }
        quickSort(array, start, right);
        quickSort(array, left, end);
    }
}
