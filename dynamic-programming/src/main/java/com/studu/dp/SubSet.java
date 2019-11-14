package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

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

        System.out.println(subSet.dpSubset(arr, 9));
        System.out.println(subSet.dpSubset(arr, 10));
        System.out.println(subSet.dpSubset(arr, 11));
        System.out.println(subSet.dpSubset(arr, 12));
        System.out.println(subSet.dpSubset(arr, 13));
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

        boolean[][] subset = new boolean[arr.length][s + 1];
        for (int j = 0; j <= s; j++) {
            subset[0][j] = true;
        }

        for (int j = 0; j < arr.length;j++) {
            subset[j][0] = false;
        }

        if (arr[0] < (s + 1)) {
            subset[0][arr[0]] = true;
        }

        for (int k = 1; k < arr.length; k++) {
            for (int m = 1; m < (s + 1); m++) {
                if (arr[k] > m) {
                    subset[k][m] = subset[k - 1][m];
                } else {
                    boolean a = subset[k - 1][m - arr[i]];
                    boolean b = subset[k - 1][m];
                    System.out.println("a = " + a);
                    System.out.println("b = " + b);
                    System.out.println("a || b = " + (a || b));
                    subset[k][m] = a || b;
                }
            }
        }
        System.out.println(Arrays.toString(subset[arr.length-1]));
        return subset[arr.length - 1][s];
    }

}
