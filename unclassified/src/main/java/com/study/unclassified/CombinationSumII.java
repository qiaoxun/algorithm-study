package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();
    List<int[]> freq = new ArrayList<>();

    @Test
    public void test() {
//        int[] candidates = {2,2};
        int[] candidates = {10,1,2,7,6,1,5};
//        int[] candidates = {2,5,2,1,2};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        calculate(0, target);
        return ans;
    }

    public void calculate(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }

        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        calculate(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(pos)[0]);
            calculate(pos + 1, rest - i * freq.get(pos)[0]);
        }

        for (int i = 1; i <= most; i++) {
            sequence.remove(sequence.size() - 1);
        }
    }

    // ======================================================

    public List<List<Integer>> combinationSum2_bak(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        calculate_bak(candidates, target, 0, new ArrayList<Integer>(), result);
        System.out.println(result);
        return result;
    }

    public void calculate_bak(int[] candidates, int target, int cursor, List<Integer> combination, List<List<Integer>> result) {
        if (cursor >= candidates.length) return;

        int candidate = candidates[cursor];
        if (target == candidate) {
            combination.add(candidate);
            result.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        } else if (candidate < target) {
            combination.add(candidate);
            calculate_bak(candidates, target - candidate, cursor + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
        calculate_bak(candidates, target, cursor + 1, combination, result);
    }

    public void calculate1(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int cursor) {
        if (cursor == candidates.length) return;

        if (candidates[cursor] == target) {
            combination.add(candidates[cursor]);
            result.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        } else {
            combination.add(candidates[cursor]);
            calculate1(result, combination, candidates, target - candidates[cursor], cursor + 1);
            combination.remove(combination.size() - 1);
        }

        if (candidates[cursor] > target) {
            calculate1(result, combination, candidates, target - candidates[cursor], cursor + 1);
        }
    }

}
