package com.study.unclassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> result = new PermutationsII().permuteUnique(nums);
        result.forEach(node -> {
            System.out.println(node);
        });
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, used, current, result);
        return result;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            dfs(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

}
