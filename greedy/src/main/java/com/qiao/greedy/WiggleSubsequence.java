package com.qiao.greedy;

public class WiggleSubsequence {

    public static void main(String[] args) {

        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int nums1[] = {1,17,5,10,13,15,10,5,16,8};
        int value1 = wiggleSubsequence.wiggleMaxLength(nums1);
        System.out.println(value1);

        int nums2[] = {1,7,4,9,2,5};
        int value2 = wiggleSubsequence.wiggleMaxLength(nums2);
        System.out.println(value2);


        int nums3[] = {1,2,3,4,5,6,7,8,9};
        int value3 = wiggleSubsequence.wiggleMaxLength(nums3);
        System.out.println(value3);
    }

    public int wiggleMaxLength(int[] nums) {

        // -1 means down, 1 means up
        int trending = 0;
        int currentValue = nums[0];
        int nextValue = 0;
        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {
            nextValue = nums[i];
            if (nextValue > currentValue) {
                currentValue = nextValue;
                if (trending == 0) {
                    trending = 1;
                    maxLength++;
                } else if (trending < 0) {
                    trending = 1;
                    maxLength++;
                }
            } else if (nextValue < currentValue) {
                currentValue = nextValue;
                if (trending == 0) {
                    trending = -1;
                    maxLength++;
                } else if (trending > 0) {
                    trending = -1;
                    maxLength++;
                }
            }
        }

        return maxLength;
    }

}
