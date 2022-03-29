package com.study.unclassified;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 3};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.maxHeapify(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void maxHeapify(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int parentIndex = findParent(i, array);
            if (array[i] > array[parentIndex]) {
                swap(i, parentIndex, array);
            }
        }
    }

    public void swap(int pos0, int pos1, int[] array) {
        int temp = array[pos0];
        array[pos0] = array[pos1];
        array[pos1] = temp;
    }

    private Integer findParent(int i, int[] array) {
        return (i - 1) / 2;
    }

    private Integer findLeftChild(int i, int[] array) {
        int index = 2 * i;
        if (array.length > index) {
            return array[index];
        }
        return null;
    }

    private Integer findRightChild(int i, int[] array) {
        int index = 2 * i + 1;
        if (array.length > index) {
            return array[index];
        }
        return null;
    }

}
