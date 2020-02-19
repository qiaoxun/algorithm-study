package com.studu.dp;

import org.junit.Test;

public class MaximumProductSubarray {

    @Test
    public void test() {
        int[] nums = {1, 3, 4, -1, 12, 4};
        int[] nums1 = {-2,0,-1};
        int[] nums2 = {-2,-1,-1};
        int[] nums3 = {2,3,-2,4};
        int[] nums4 = {2,3,-2,4,-2};
        int[] nums5 = {2,3,-2,4,-2, -1};
        int[] nums6 = {2,3,-2,4,-2, -1, -2};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
        System.out.println(maxProduct(nums3));
        System.out.println(maxProduct(nums4));
        System.out.println(maxProduct(nums5));
        System.out.println(maxProduct(nums6));
    }


    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = n > maxProduct * n ? n : maxProduct * n;
            minProduct = n < minProduct * n ? n : minProduct * n;
            ans = ans > maxProduct ? ans : maxProduct;
        }

        return ans;
    }

}
