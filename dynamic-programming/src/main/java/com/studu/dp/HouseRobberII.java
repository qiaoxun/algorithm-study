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
        int preMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(preMax + nums[i], currMax);
            preMax = temp;
        }
        return currMax;
    }

}
