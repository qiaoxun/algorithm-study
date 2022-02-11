package com.study.unclassified;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates.removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }


    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int slow = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                nums[++slow] = nums[i];
            }
        }
        return slow + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int tmp = nums[0];
        int length = nums.length;
        int slow = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] != tmp) {
                tmp = nums[i];
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public int removeDuplicates1(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int tmp = nums[0];
        int count = 1;

        int length = nums.length;

        for (int i = 1; i < length; i++) {
            if (nums[i] == tmp) {
                moveForward(nums, i, length);
                i--;
                length --;
            } else {
                tmp = nums[i];
                count++;
            }
        }
        return count;
    }

    private void moveForward(int[] nums, int index, int length) {
        for (int i = index; i < length; i++) {
            if (i == nums.length - 1) {
                nums[i] = 0;
                break;
            }
            nums[i] = nums[i + 1];
        }
    }
}
