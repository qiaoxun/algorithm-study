package com.study.sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * heap sort
 * 1. parent = (index - 1) / 2
 * 2. left child = 2 * index + 1
 * 3. right child = 2 * index + 2
 */
public class HeapSort {

    @Test
    public void test() {
        int[] arr = {2, 5, 3, 1, 10, 4};
        int arrLength = arr.length;
        for (int i = arrLength - 1; i >= 0; i--) {
            buildHeap(arr, i);
            swap(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * find the biggest num from arr
     * @param arr
     * @param n
     */
    public void buildHeap(int[] arr, int n) {
        // from last parent to heapify
        int lastParent = (n - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     *
     * @param arr
     * @param n index of the arr (length - 1)
     * @param i i
     */
    public void heapify(int[] arr, int n, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild <= n && arr[leftChild] > arr[i]) {
            swap(arr, i, leftChild);
        }
        if (rightChild <= n && arr[rightChild] > arr[i]) {
            swap(arr, i, rightChild);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

}
