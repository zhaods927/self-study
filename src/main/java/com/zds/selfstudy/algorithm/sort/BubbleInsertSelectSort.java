package com.zds.selfstudy.algorithm.sort;

import java.util.Arrays;

/**
 * @program: self-study
 * @description: 冒泡、插入、选择排序
 * @author: zhaods
 * @create: 2020-10-03 21:20
 **/
public class BubbleInsertSelectSort {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 45, 23, 7, 6, 7, 1, 10};
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(insertSort(array)));
        System.out.println(Arrays.toString(selectSort(array)));
    }

    /**
     * 冒泡排序
     */
    private static int[] bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序
     */
    private static int[] insertSort(int[] array) {
        int insertNode;
        int temp;
        for (int i = 1; i < array.length; i++) {
            insertNode = array[i];
            temp = i - 1;
            while (temp >= 0 && insertNode < array[i]) {
                array[temp + 1] = array[temp];
                temp--;
            }
            array[temp + 1] = insertNode;
        }
        return array;
    }

    /**
     * 选择排序
     */
    private static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[pos] > array[i]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
            }
        }
        return array;
    }


}
