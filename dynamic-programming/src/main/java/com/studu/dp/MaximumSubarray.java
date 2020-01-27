package com.studu.dp;

import org.junit.Test;

public class MaximumSubarray {

    /**
     *
     */
    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * brute force
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = max > sum ? max : sum;
            }
        }
        return max;
    }

    /**
     * DP
     */
    public int maxSubArray_DP(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = max > sum ? max : sum;
            }
        }
        return max;
    }
}
