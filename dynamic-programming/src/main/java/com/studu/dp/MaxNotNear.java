package com.studu.dp;

import org.junit.Test;

/**
 * 求数组内，最大的各不相邻数据的最大和
 */
public class MaxNotNear {

    @Test
    public void test() {
        int[] arr = {1 ,2, 4, 1, 7, 8, 3};
        MaxNotNear maxNotNear = new MaxNotNear();
        System.out.println(maxNotNear.recurseMax(arr, arr.length - 1));
        System.out.println(maxNotNear.dpMax(arr));
    }

    public int recurseMax(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int a = recurseMax(arr, i - 2) + arr[i];
            int b = recurseMax(arr, i - 1);
            return Math.max(a, b);
        }
    }

    public int dpMax(int[] arr) {
        int[] newArr = new int[arr.length];
        newArr[0] = arr[0];
        newArr[1] = Math.max(arr[0], arr[1]);
        for (int j = 2; j < arr.length; j++) {
            int a = newArr[j - 2] + arr[j];
            int b = newArr[j - 1];
            newArr[j] = Math.max(a, b);
        }
        return newArr[arr.length - 1];
    }

}
