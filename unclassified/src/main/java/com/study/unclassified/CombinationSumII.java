package com.study.unclassified;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        return null;
    }

    public void calculate(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int cursor) {
        if (cursor == candidates.length) return;

        if (candidates[cursor] == target) {
            combination.add(candidates[cursor]);
            result.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        } else {
            combination.add(candidates[cursor]);
            calculate(result, combination, candidates, target - candidates[cursor], cursor + 1);
            combination.remove(combination.size() - 1);
        }


        if (candidates[cursor] > target) {
            calculate(result, combination, candidates, target - candidates[cursor], cursor + 1);
        }
    }

}
