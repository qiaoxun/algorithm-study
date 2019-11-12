package com.studu.dp;

import org.junit.Test;

/**
 * 给定一个数，求数组中有没有数的和等于这个数
 */
public class SubSet {

    @Test
    public void test() {
        SubSet subSet = new SubSet();
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(subSet.recSubset(arr, arr.length - 1, 9));
        System.out.println(subSet.recSubset(arr, arr.length - 1, 10));
        System.out.println(subSet.recSubset(arr, arr.length - 1, 11));
        System.out.println(subSet.recSubset(arr, arr.length - 1, 12));
        System.out.println(subSet.recSubset(arr, arr.length - 1, 13));
    }

    /**
     * recursion
     * @param arr
     * @param i
     * @param s
     * @return
     */
    public boolean recSubset(int arr[], int i, int s) {
        if (s == 0) {
            return true;
        }
        int value = arr[i];
        if (i == 0) {
            return s == value;
        } else if (s == 0) {
            return true;
        } else if (value > s) {
            return recSubset(arr, i - 1, s);
        } else {
            // 选
            if (recSubset(arr, i - 1, s - value)) {
                return true;
            } else if (recSubset(arr, i - 1, s)) { // 不选
                return true;
            }
        }
        return false;
    }

    public boolean dpSubset(int arr[], int s) {
        int i = arr.length - 1;

        if (s == 0) {
            return true;
        } else if ()

        return false;
    }

}
