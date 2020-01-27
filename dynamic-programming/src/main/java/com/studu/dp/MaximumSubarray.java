package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 */
public class MaximumSubarray {

    /**
     *
     */
    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {-2,-1,-3};
        int[] nums2 = {1, -1, 5, -4, 0, 1, 2};
//        System.out.println(maxSubArray(nums));
//        System.out.println("DP nums " + maxSubArray_DP(nums));
//        System.out.println(maxSubArray(nums1));
//        System.out.println("DP nums1 " + maxSubArray_DP(nums1));
//        System.out.println("DP nums2 " + maxSubArray_DP(nums2));
//        System.out.println("DP1 nums " + maxSubArray_DP1(nums));
//        System.out.println("DP1 nums1 " + maxSubArray_DP1(nums1));
//        System.out.println("DP1 nums2 " + maxSubArray_DP1(nums2));
        System.out.println("Greedy nums " + maxSubArray_Greedy(nums));
        System.out.println("Greedy nums1 " + maxSubArray_Greedy(nums1));
        System.out.println("Greedy nums2 " + maxSubArray_Greedy(nums2));
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

        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i - 1] + nums[i]) > nums[i] ? dp[i - 1] + nums[i] : nums[i];
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    public int maxSubArray_DP1(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }

    public int maxSubArray_Greedy(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }

            max = max > currentSum ? max : currentSum;
        }
        return max;
    }

}
