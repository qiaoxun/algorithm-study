package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Three3Sum {

    @Test
    public void test() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(array));
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
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

        }
        return result;
    }
}
