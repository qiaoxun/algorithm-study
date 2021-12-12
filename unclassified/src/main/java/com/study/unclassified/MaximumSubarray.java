package com.study.unclassified;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {1};
        int[] nums2 = {5,4,-1,7,8};
        int[] nums3 = {-1};
        int[] nums4 = {-4, -2, -3};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            max = Math.max(currSum, max);
        }
        return max;
    }

    /**
     * 暴力
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int maximumResult = nums[0];
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentMaximumResult = nums[i];
            if (currentMaximumResult > maximumResult) {
                startIndex = i;
                endIndex = i;
                maximumResult = currentMaximumResult;
            }

            for (int j = i + 1; j < nums.length; j++) {
                currentMaximumResult += nums[j];
                if (currentMaximumResult > maximumResult) {
                    startIndex = i;
                    endIndex = j;
                    maximumResult = currentMaximumResult;
                }
            }
        }
        System.out.println("Start Index: " + startIndex + ", End Index: " + endIndex);
        return maximumResult;
    }

}
