package com.study.unclassified;

import org.junit.Test;

public class JumpGameII {

    @Test
    public void test() {
//        int[] nums = {1, 1, 2};
        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return jump1(nums, 1, 1);
    }

    private int jump1(int[] nums, int index, int jumps) {
        for (int i = index; i <= nums.length; i++) {
            int steps = nums[i - 1];

            if (steps >= nums.length - i) {
                return jumps;
            }

            int maxValue = 0;
            int maxIndex = i + 1;
            for (int j = 1; j <= steps; j++) {
                int currentValue = nums[i + j - 1];
                if (maxValue <= currentValue + j) {
                    maxValue = currentValue;
                    maxIndex = i + j;
                }
            }
            return jump1(nums, maxIndex, jumps + 1);
        }
        return jumps;
    }

}
