package com.studu.dp;

import org.junit.Test;

/**
 * 有w件物品和一个容量为c的背包。第i件物品的费用是w[i]，价值是v[i]。求解将哪些物品装入背包可使价值总和最大。
 */
public class KnapsackProblem {

    @Test
    public void test() {
        int[] w = {0, 2, 3, 4, 5, 9};
        int[] v = {0, 3, 4, 5, 8, 10};
        int c = 20 + 1;
        System.out.println(knapsack(w, v, c));
    }

    public int knapsack(int[] w, int[] v, int c) {
        if (w.length == 0 || c == 0) {
            return 0;
        }
        int dp[][] = new int[w.length][c];

        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j < c; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i - 1][j - w[i]] + v[i];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < c; j++) {
                int dpV = dp[i][j];
                System.out.print( (dpV > 9 ? dpV : " " + dpV) + " ");
            }
            System.out.println();
        }
        return dp[w.length - 1][c - 1];
    }

}
