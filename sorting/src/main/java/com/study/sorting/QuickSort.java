package com.study.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 2, 4, 3, 1, 4, 0, 3, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        int l = i;
        int r = j;
        int pivot = arr[i];
        boolean right = true;

        while (i <= j) {
            if (right) {
                if (pivot > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = pivot;
                    right = false;
                } else {
                    j--;
                }
            } else {
                if (pivot < arr[i]) {
                    arr[j] = arr[i];
                    arr[i] = pivot;
                    right = true;
                } else {
                    i++;
                }
            }
        }

        if (i == j) {
            arr[i] = pivot;
        }

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

}
