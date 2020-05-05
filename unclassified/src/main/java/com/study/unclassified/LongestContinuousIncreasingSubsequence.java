package com.study.unclassified;

import org.junit.Test;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class LongestContinuousIncreasingSubsequence {

    @Test
    public void test() {
        int[] nums = {1,1,1,4,7};
        int[] nums1 = {3,3,1,1,1};
        int[] nums2 = {1};
        int[] nums3 = {};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS(nums1));
        System.out.println(findLengthOfLCIS(nums2));
        System.out.println(findLengthOfLCIS(nums3));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int lcis = 1;
        int current = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[j - 1]) {
                lcis = Math.max(j - current + 1, lcis);
            } else {
                current = j;
            }
        }
        return lcis;
    }

    public int findLengthOfLCIS_20200505(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int lcis = 1;
        int current = 0;
        outer:
        while (current < nums.length) {
            for (int j = current + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    lcis = Math.max(j - current + 1, lcis);
                } else {
                    current = j;
                }
                if (j == nums.length - 1) break outer;
            }
        }
        return lcis;
    }

}
