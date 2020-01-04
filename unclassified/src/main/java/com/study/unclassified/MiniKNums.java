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

    // --------------------------------------------------------------------------

    @Test
    public void testHeapSortVersion() {
        int[] arr = {1, 3, 5, 6, 2, 4, 3, 1, 4, 0, 3, 2, 0, 0};
        heapSortVersion(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSortVersion(int arr[], int k) {
        for (int i = 0; i < k; i++) {
            buildHeap(arr, i);
            swap(arr, 0, arr.length - 1 - i);
        }
    }

    private void buildHeap(int[] arr, int index) {
        int length = arr.length - index - 1;

        int lastParentNodeIndex = (length - 1) / 2;

        for (int i = lastParentNodeIndex; i >= 0; i--) {
            heapify(arr, i, length);
        }
    }

    private void heapify(int[] arr,int parentIndex, int length) {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        if (rightChildIndex < length) {
            if (arr[parentIndex] > arr[rightChildIndex]) {
                swap(arr, parentIndex, rightChildIndex);
            }
        }

        if (arr[parentIndex] > arr[leftChildIndex]) {
            swap(arr, parentIndex, leftChildIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    // --------------------------------------------------------------------------

    @Test
    public void test() {
        int[] arr = {1, 3, 5, 6, 2, 4, 3, 1, 4, 0, 3, 2, 0, 0};
        int[] smallArr = kSmallNums(arr, 4);
        System.out.println(Arrays.toString(smallArr));
    }

    public int[] kSmallNums(int[] arr, int k) {
        if (k > arr.length) return arr;

        int[] kArr = new int[k];
        System.arraycopy(arr, 0, kArr, 0, k);
        sortArr(kArr);

        for (int i = k; i < arr.length; i++) {
            int max = kArr[kArr.length - 1];
            if (arr[i] < max) {
                kArr[kArr.length - 1] = arr[i];
                sortArr(kArr);
            }
        }

        return kArr;
    }

    private void sortArr(int[] arr) {
        Arrays.sort(arr);
    }

}
