package com.qiao.greedy;

public class JumpGame {

    public static void main(String[] args) {

        int[] nums1 = new int[]{0, 3, 1, 1, 4};
        int[] nums2 = new int[]{3,2,1,0,4};
        int[] nums3 = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};

        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(nums1);
        System.out.println(result);
        result = jumpGame.canJump(nums2);
        System.out.println(result);
        result = jumpGame.canJump(nums3);
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int length = nums.length - 1;
        int i = 0;

        if (length == 1)
            return true;

        while (i <= maxIndex) {
            int currentIndex = i + nums[i];
            if (currentIndex >= length) {
                return true;
            } else {
                if (currentIndex > maxIndex) {
                    maxIndex = currentIndex;
                }
                i++;
            }
        }

        return false;
    }


}
