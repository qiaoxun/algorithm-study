package com.study.unclassified;

import org.junit.Test;

import java.util.Arrays;

/**
 * 求 n 个数中最小的 k 个数
 */
public class MiniKNums {

    @Test
    public void testQuickSortVersion() {
        int[] arr = {1, 3, 5, 6, 2, 4, 3, 1, 4, 0, 3, 2, 0, 0};
        quickSortVersion(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快排版本
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return
     */
    public int quickSortVersion(int[] arr, int left, int right, int k) {
        if (right <= left) return left;
        int i = left;
        int j = right;

        int pivot = arr[right];

        boolean leftPlus = true;

        while (i < j) {
            if (leftPlus) {
                if (arr[i] > pivot) {
                    arr[j] = arr[i];
                    arr[i] = pivot;
                    leftPlus = false;
                } else {
                    i++;
                }
            } else {
                if (arr[j] < pivot) {
                    arr[i] = arr[j];
                    arr[j] = pivot;
                    leftPlus = true;
                } else {
                    j--;
                }
            }
        }
        System.out.println("i = " + i + ", j = " + j);
        if (i == j) {
            arr[i] = pivot;
        }

        if (i >= 0 && i <= arr.length - 1) {
            quickSortVersion(arr, left, i - 1, k);
            if (i < k - 1) {
                quickSortVersion(arr, j + 1, right, k);
            }
        }

        return i;
    }

}
