package com.study.unclassified;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<int[]> list = new ArrayList<>();
        helper(nums, new int[nums.length], 0, list);

        return null;
    }

    private int[] helper(int[] nums, int[] singleResult, int index, List<int[]> result) {
        for (int i = index; i < nums.length; i++) {
            singleResult[index] = nums[i];
            helper(nums, singleResult, index + 1);
        }
        return result;
    }


}
