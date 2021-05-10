package com.study.unclassified;

import org.junit.Test;

public class JumpGameII {

    @Test
    public void test() {
//        int[] nums = {1, 1, 2};
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
//        int[] nums = {2,9,6,5,7,0,7,2,7,9,3,2,2,5,7,8,1,6,6,6,3,5,2,2,6,3};
        int[] nums = {9,4,5,4,1,8,1,2,0,7,8,7,0,6,6,1,1,2,5,0,9,8,4,7,9,6,8,1,4,0,8,5,5,3,9,8,1,2,2,3,0,1,3,2,7,9,3,0,1};
        System.out.println(jump2(nums));
    }

    public int jump(int[] nums) {
        int steps = 0;
        int position = nums.length - 1;

        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    steps++;
                    position = i;
                }
            }
        }
        return steps;
    }

    public int jump1(int[] nums) {
        int steps = 0;
        int maxPosition = 0;
        int end = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }



    public int jump2(int[] nums) {
        int steps = 0;
        int end = nums[0];
        int max = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                steps ++;
                end = max;
            }
        }

        return steps;
    }









    // Solution 1
//    public int jump(int[] nums) {
//        int position = nums.length - 1;
//        int steps = 0;
//
//        while (position > 0) {
//            for (int i = 0; i < position; i++) {
//                if (nums[i] + i >= position) {
//                    steps++;
//                    position = i;
//                }
//            }
//        }
//        return steps;
//    }

//    public int jump(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//        int[] minJumps = new int[1];
//        minJumps[0] = nums.length;
//        return jumpUtil(nums, 0, 0, minJumps);
//    }
//
//    private int jumpUtil(int[] nums, int index, int jumps, int[] minJumps) {
//        if (jumps > minJumps[0]) {
//            return minJumps[0];
//        }
//        for (int i = index; i < nums.length; i++) {
//            jumps++;
//            if (nums[i] >= nums.length - i - 1) {
//                minJumps[0] = Math.min(minJumps[0], jumps);
//                return minJumps[0];
//            } else {
//                for (int j = 1; j <= nums[i]; j++) {
//                    jumpUtil(nums, i + j, jumps, minJumps);
//                }
//            }
//        }
//        minJumps[0] = Math.min(minJumps[0], jumps);
//        return minJumps[0];
//    }
//
//    @Test
//    public void test2() {
//        paraTest(1, 0);
//    }
//
//    private void paraTest(int jumps, int depth) {
//        if (depth >= 2) {
//            return;
//        }
//        for (int i = 0; i < 2; i++) {
//            jumps++;
//            System.out.println(jumps);
//            depth ++;
//            paraTest(jumps, depth);
//        }
//    }

//    private int jump1(int[] nums, int index, int jumps) {
//        for (int i = index; i <= nums.length; i++) {
//            int steps = nums[i - 1];
//
//            if (steps >= nums.length - i) {
//                return jumps;
//            }
//
//            int maxValue = 0;
//            int maxIndex = i + 1;
//            for (int j = 1; j <= steps; j++) {
//                int currentValue = nums[i + j - 1];
//                if (maxValue <= currentValue + j) {
//                    maxValue = currentValue;
//                    maxIndex = i + j;
//                }
//            }
//            return jump1(nums, maxIndex, jumps + 1);
//        }
//        return jumps;
//    }

}
