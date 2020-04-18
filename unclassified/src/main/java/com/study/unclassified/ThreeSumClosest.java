package com.study.unclassified;

import org.junit.Test;

import java.util.Arrays;

public class ThreeSumClosest {

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int[] nums1 = {0, 1, 2};
        int[] nums2 = {1, 1, 1, 0};
        int[] nums3 = {1, 1, -1, -1, 3};
        System.out.println(threeSumClosest(nums, -4));
        System.out.println(threeSumClosest(nums1, 3));
        System.out.println(threeSumClosest(nums2, 100));
        System.out.println(threeSumClosest(nums3, 1));
    }


    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        int result = Integer.MAX_VALUE;

        Arrays.sort(nums);
        int closestGap = Integer.MAX_VALUE;
        outer:
        for (int i = 1; i < nums.length - 1; i++) {
            int L = i -1;
            int R = i + 1;

            while (L >= 0 && R < nums.length) {
                int sum = nums[L] + nums[i] + nums[R];
                if (Math.abs(sum - target) <= closestGap) {
                    closestGap = Math.abs(sum - target);
                    result = sum;
                    if (result == target) {
                        break outer;
                    }
                }
                if (sum - target > 0) {
                    L--;
                } else {
                    R++;
                }
            }
        }
        return result;
    }

    public int threeSumClosest_Wrong(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        int result = Integer.MAX_VALUE;

        Arrays.sort(nums);
        int closestIndex = 0;
        int closestGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - target) <= closestGap) {
                closestGap = Math.abs(nums[i] - target);
                closestIndex = i;
            }
        }

        if (closestIndex == 0) {
            return nums[0] + nums[1] + nums[2];
        }

        if (closestIndex == nums.length - 1) {
            return nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        }

        int L = closestIndex - 1;
        int R = closestIndex + 1;

        closestGap = Integer.MAX_VALUE;

        while (L >= 0 && R < nums.length) {
            int sum = nums[L] + nums[closestIndex] + nums[R];
            if (Math.abs(sum - target) <= closestGap) {
                closestGap = Math.abs(sum - target);
                result = sum;
            }
            if (sum - target > 0) {
                L--;
            } else {
                R++;
            }
        }
        return result;
    }

}
