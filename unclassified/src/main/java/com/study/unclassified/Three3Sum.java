package com.study.unclassified;

import org.junit.Test;

import java.util.*;

public class Three3Sum {

    @Test
    public void test() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        int[] array1 = {0, 0, 0};
        int[] array2 = {-1, 0, 1};
//        System.out.println(threeSum(array));
//        System.out.println(threeSum(array1));
//        System.out.println(threeSum1(array));
        System.out.println(threeSum1(array1));
        System.out.println(threeSum1(array2));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        // remove duplicate list
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (L == i) {
                    L++;
                }
                if (R == i) {
                    R--;
                }

                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        return result;
    }
}
