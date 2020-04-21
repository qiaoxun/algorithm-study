package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    @Test
    public void test() {
       int[] nums = {1, 0, -1, 0, -2, 2};
       int[] nums1 = {0, 0, 0, 0};
       int[] nums2 = {-3,-1,0,2,4,5};
       int[] nums3 = {2,-4,-5,-2,-3,-5,0,4,-2};
       int[] nums4 = {0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
//        System.out.println(fourSum(nums, 0));
        System.out.println(fourSum(nums1, 0));
//        System.out.println(fourSum(nums1, 1));
//        System.out.println(fourSum(nums2, 1));
//        System.out.println(fourSum(nums3, -14));
//        System.out.println(fourSum_bak(nums3, -14));
        System.out.println(fourSum(nums4, 6));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (null == nums || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int leftTarget = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 最小的和都大于 target，没必要继续了
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            leftTarget = target - nums[i];

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 最小的和都大于 target，没必要继续了
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == leftTarget) {
                        List<Integer> resultList = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        lists.add(resultList);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum > leftTarget) {
                        right--;
                    } else if (sum < leftTarget) {
                        left++;
                    }
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> fourSum_20200421(int[] nums, int target) {
        if (null == nums || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int leftTarget = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            leftTarget = target - nums[i];

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
//                if (i == j) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
//                    if (right == i || right == j) {
//                        right--;
//                        continue;
//                    }
//                    if (left == i || left == j) {
//                        left++;
//                        continue;
//                    }
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == leftTarget) {
                        List<Integer> resultList = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
//                        List<Integer> exsits = lists.stream().filter(eachList -> eachList.containsAll(resultList) && resultList.containsAll(eachList)).findFirst().orElse(null);
//                        if (null == exsits || exsits.size() == 0) {
                        lists.add(resultList);
//                        }
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum > leftTarget) {
                        right--;
                    } else if (sum < leftTarget) {
                        left++;
                    }
                }
            }
        }
        return lists;
    }



    public List<List<Integer>> fourSum_bak(int[] nums, int target) {
        if (null == nums || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int leftTarget = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
                continue;
            }
            leftTarget = target - nums[i];

            for (int j = 1; j < nums.length - 1; j++) {
                if (i == j) continue;
                int left = 0;
                int right = nums.length - 1;

                while (left < right) {
                    while (right == i || right == j) {
                        right--;
                        continue;
                    }
                    while (left == i || left == j) {
                        left++;
                        continue;
                    }

                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == leftTarget) {
                        List<Integer> resultList = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        while (right > 0 && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        List<Integer> exsits = lists.stream().filter(eachList -> { return  eachList.containsAll(resultList);}).findFirst().orElse(null);
                        if (null == exsits || exsits.size() == 0) {
                            lists.add(resultList);
                        }
                        left++;
                        right--;
                    } else if (sum > leftTarget) {
                        while (right > 0 && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < leftTarget) {
                        while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    }
                }
            }
        }
        return lists;
    }
}
