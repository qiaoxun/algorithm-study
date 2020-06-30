package com.study.unclassified;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid = length / 2;

//        while (mid >= 0 && mid < length) {
//            if (nums[mid] < target) {
//                if (nums[mid] < nums[right]) { // target in right
//                    // right part is in ascending order, nums[mid] < target and nums[mid] < nums[right], so target in right
//                    mid = (mid + right) / 2;
//                    left = mid;
//                } else {
//                    if (nums[left] < nums[mid]) {
//                        // left part is in ascending order, and mid < target, so target in right
//                        mid = (mid + right) / 2;
//                        left = mid;
//                    } else { // target in left
//                        mid = (left + mid) / 2;
//                        right = mid;
//                    }
//                }
//            } else if (nums[mid] > target) {
//                if (nums[left] < nums[mid]) { //
//                    mid =
//                }
//
//
//            } else if (nums[mid] == target) {
//                return mid;
//            }
//        }

        return -1;
    }

}
