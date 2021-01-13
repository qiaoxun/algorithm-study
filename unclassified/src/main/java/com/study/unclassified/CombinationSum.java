package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    @Test
    public void test() {
        int[] candidates = { 1, 2 };
        int target = 2;
        System.out.println(combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates,  int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(ans, combine, candidates, target, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> combine, int[] candidates, int target, int idx) {
        // solution found
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        // No solution
        if (idx == candidates.length) {
            return;
        }

        dfs(ans, combine, candidates, target, idx + 1);

        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(ans, combine, candidates, target - candidates[idx], idx);
            combine.remove(combine.size() - 1);
        }
    }

}
