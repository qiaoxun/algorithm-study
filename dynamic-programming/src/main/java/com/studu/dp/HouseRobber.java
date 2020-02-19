package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/house-robber/
 *
 *  0 1 2 3 4 5 6
 *  1 2 3 5 1 4 8
 *
 *  dp[i] = max(dp[i - 2] + arr[i], dp[i-1])
 *
 *  dp[0] = 1;
 *  dp[1] = 2;
 *  dp[2] = dp[0] + arr[2] = 1 + 3 = 4
 *  dp[3] = dp[1] + arr[3] = 2 + 5 = 7
 *  dp[4] = dp[3] = 7
 *  dp[5] = dp[3] + arr[5] = 7 + 4 = 11
 *  dp[6] = dp[4] + arr[6] = 7 + 8 = 15
 */
public class HouseRobber {

    @Test
    public void test() {
        int[] nums = {1,2,3,1};
        int[] nums1 = {2,7,9,3,1};
        int[] nums2 = {1, 2, 3, 5, 1, 4, 8};
        int[] nums3 = {2, 1, 1, 2};
        int[] nums4 = {2, 1, 1, 1, 2};
        int[] nums5 = {2, 1};
        System.out.println(rob(nums));
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
        System.out.println(rob(nums4));
        System.out.println(rob(nums5));
    }

    /**
     * DP
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

}
