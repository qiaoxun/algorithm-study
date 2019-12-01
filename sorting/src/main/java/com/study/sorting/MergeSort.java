package com.study.sorting;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    @Test
    public void test() {
        int[] arr = {1, 5, 7, 9, 2, 4, 5, 1, 19, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (r + l) / 2;
        System.out.println("l = " + l + ", m = " + m + ", r = " + r);
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m + 1, r);
    }

    @Test
    public void test1() {
        int[] arr = {1, 5, 7, 9, 2, 4, 5, 1};
        merge(arr, 0, 4, 6);
        System.out.println(Arrays.toString(arr));
    }

    public void merge(int[] arr, int l, int m, int r) {
        if (l == r) {
            return;
        }
        int[] leftArr = new int[m - l];
        int[] rightArr = new int[r - m + 1];

        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        System.arraycopy(arr, l, leftArr, 0, leftSize);
        System.arraycopy(arr, m, rightArr, 0, rightSize);

//        System.out.println(Arrays.toString(leftArr));
//        System.out.println(Arrays.toString(rightArr));

        int i = 0, j = 0, k = l;

        while (i < leftSize && j < rightSize) {
            int lv = leftArr[i];
            int rv = rightArr[j];
            if (lv < rv) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

}
