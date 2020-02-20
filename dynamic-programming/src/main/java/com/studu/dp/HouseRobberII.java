package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobberII {

    @Test
    public void test() {
        int nums[] = {1, 2, 3, 4};
        int nums1[] = {4, 2, 3, 4};
        System.out.println(rob(nums));
        System.out.println(rob(nums1));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int preMax = 0;
        int currMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(preMax + nums[i], currMax);
            preMax = temp;
        }

        int preMax1 = 0;
        int currMax1 = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int temp = currMax1;
            currMax1 = Math.max(preMax1 + nums[i], currMax1);
            preMax1 = temp;
        }

        return currMax > currMax1 ? currMax : currMax1;
    }

}
