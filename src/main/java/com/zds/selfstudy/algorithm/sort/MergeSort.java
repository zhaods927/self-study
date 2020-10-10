package com.zds.selfstudy.algorithm.sort;

import java.util.Arrays;

/**
 * @program: self-study
 * @description: 归并排序
 * @author: zhaods
 * @create: 2020-10-03 21:28
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 45, 23, 7, 6, 7, 1, 10};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    private static void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int medium = (start + end) / 2;
        mergeSort(array, start, medium, temp);
        mergeSort(array, medium + 1, end, temp);
        merge(array, start, medium, end, temp);
    }

    private static void merge(int[] array, int start, int medium, int end, int[] temp) {
        int left = start;
        int right = medium + 1;
        int index = start;
        while (left <= medium && right <= end) {
            if (array[left] < array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= medium) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (index = start; index <= end; index++) {
            array[index] = temp[index];
        }

    }

}