package com.study.unclassified;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        List<List<Integer>> result = permutations.permute(new int[] {1, 1, 3});
        result.forEach(each -> {
            System.out.println(Arrays.toString(each.toArray()));
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        int depth = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        boolean[] used = new boolean[len];
        dfs(nums, len, depth, stack, used, list);

        return list;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> stack, boolean[] used, List<List<Integer>> result) {
        if (len == depth) {
            result.add(new ArrayList(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            stack.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, stack, used, result);

            stack.removeLast();
            used[i] = false;
        }
    }


}
