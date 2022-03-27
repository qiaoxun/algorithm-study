package com.study.unclassified;

public class MaxHeap {

    public static void main(String[] args) {

    }

    private Integer findLeftChild(int i, int[] array) {
        int index = 2 * (i + 1);
        if (array.length > index) {
            return array[index];
        }
        return null;
    }

    private Integer findRightChild(int i, int[] array) {
        int index = 2 * (i + 1) + 1;
        if (array.length > index) {
            return array[index];
        }
        return null;
    }

}
