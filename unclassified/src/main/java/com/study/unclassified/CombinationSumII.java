package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    @Test
    public void test() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        calculate(candidates, target, 0, new ArrayList<Integer>());
        return null;
    }
    public void calculate(int[] candidates, int target, int cursor, List<Integer> combination) {
        if (cursor >= candidates.length) return;
//        if (target < 0) {
////            combination.remove(combination.size() - 1);
//            calculate(candidates, target + candidates[cursor - 1] - candidates[cursor], cursor, combination);
//            return;
//        } else if (target == 0) {
//            System.out.println("Yes" + combination);
//            return;
//        }
//        int candidate = candidates[cursor];
//
//        combination.add(candidate);
//        calculate(candidates, target - candidate, cursor + 1, combination);
//
//        combination.remove(combination.size() - 1);
//        calculate(candidates, target, cursor + 1, combination);
        int candidate = candidates[cursor];
        if (target == candidate) {
            combination.add(candidate);
            System.out.println("Yes" + combination);
        } else if (candidate < target) {
            combination.add(candidate);
            calculate(candidates, target - candidate, cursor + 1, combination);
        } else {
            calculate(candidates, target, cursor + 1, combination);
        }

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
