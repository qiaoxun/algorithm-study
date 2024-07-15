package com.studu.dp;

public class JumpGameTwo {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {2,3,0,1,4};

        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        jumpGameTwo.jump(nums2);
    }

    public int jump(int[] nums) {
        jump(nums, nums.length - 1);
        return 1;
    }

    public void jump(int[] nums, int currentIndex) {
        if (currentIndex <= 0) {
            return;
        }

        int i = currentIndex - 1;
        while (i >= 0) {
            if (nums[i] == 0) {
                i--;
                continue;
            }
            if (nums[i] + i >= currentIndex) {
                i--;
            } else {
                i++;
                break;
            }
        }

        // record the index
        System.out.println("i == " + i);
        jump(nums, i);
    }

}
