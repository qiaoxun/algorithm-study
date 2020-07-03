package com.study.unclassified;

import org.junit.Test;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    @Test
    public void test() {
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 0, 1};
        int[] nums1 = {7, 8, 0, 1, 2, 3, 4, 5, 6};
        int[] nums2 = {4,5,6,7,0,1,2};
        int[] nums3 = {5, 1,3};

        int target = 8;
//        System.out.println(search(nums, target));
//        System.out.println(search(nums1, target));
//        System.out.println(search(nums2, 0));
        System.out.println(search(nums3, 3));
    }

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;

        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
