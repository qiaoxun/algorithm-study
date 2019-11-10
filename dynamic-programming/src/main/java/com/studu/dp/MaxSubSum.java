package com.studu.dp;

import org.junit.Test;

public class MaxSubSum {

    /**
     * 暴力求解, O(n2)
     */
    @Test
    public void test() {
        int[] arr = { -2, 11, -4, 13, -5, -2 };
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            // 每个循环的最大值
            int eachMax = arr[i];
            // 当前值
            int currentValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                currentValue = currentValue + arr[j];
                eachMax = Math.max(eachMax, currentValue);
                System.out.println("eachMax = " + eachMax);
            }
            max = Math.max(max, eachMax);
        }
        System.out.println("MaxSubSum is " + max);
    }

    @Test
    public void test1() {
        int[] arr = { -2, 11, -4, 13, -5, -2 };
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            // 当前值
            int currentValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, currentValue);
                currentValue = currentValue + arr[j];
                System.out.println("eachMax = " + max);
            }
        }
        System.out.println("MaxSubSum is " + max);
    }

    @Test
    public void test2() {
        int[] arr = { -2, 11, -4, 13, -5, -2 };

        

    }

}
