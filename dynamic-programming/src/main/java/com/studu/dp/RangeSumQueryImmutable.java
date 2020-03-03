package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {
    @Test
    public void test() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        NumArray1 numArray1 = new NumArray1(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray1.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray1.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
        System.out.println(numArray1.sumRange(0, 5));
    }

}
class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else
                sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }
}

class NumArray1 {
    private int[] sum;
    public NumArray1(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(sum));
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}