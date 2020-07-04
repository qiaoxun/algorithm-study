package com.study.unclassified;

import org.junit.Test;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

    @Test
    public void test() {
        int[] nums = {1,7,7,7,7,10};
        int[] nums1 = {2,2};
        int[] nums2 = {2};
        int target = 7;
//        System.out.println(Arrays.toString(searchRange(nums, target)));
//        System.out.println(Arrays.toString(searchRange(nums1, 3)));

//        System.out.println(findExtremeIndex(nums, 7, true));
//        System.out.println(findLeftExtremeIndex(nums2, 7, true));
        System.out.println(findExtremeIndex(nums, 7, true));
        System.out.println(findExtremeIndex(nums, 7, false));

    }

    /**
     *  log2n
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] defaultValue = {-1, -1};

        int left = findExtremeIndex(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return defaultValue;
        }

        int right = findExtremeIndex(nums, target, false) - 1;
        return new int[]{left, right};
    }

    private int findExtremeIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return  lo;
    }

    public int[] searchRange1(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return findFirstAndLast(nums, mid);
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }

    private int[] findFirstAndLast(int[] nums, int position) {
        int target = nums[position];
        int left = position;
        int right = position;
        while (left > 0) {
            if (nums[left - 1] == target) {
                left --;
            } else {
                break;
            }
        }
        while (right < nums.length - 1) {
            if (nums[right + 1] == target) {
                right ++;
            } else {
                break;
            }
        }
        return new int[] {left, right};
    }

}
