package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    @Test
    public void test() {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println("dpUniquePaths = " + uniquePaths.dpUniquePaths(7, 4));
        System.out.println("dpUniquePathsOPT = " + uniquePaths.dpUniquePathsOPT(7, 4));
    }

    /**
     *  0  1  1  1  1
     *  1  2  3  4  5
     *  1  3  6  0  0
     *  1  4  10 0  0
     * @param m
     * @param n
     * @return
     */
    public int dpUniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }

        int dp[][] = new int[m][n];

        dp[0][0] = 0;

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 优化
     * @param m
     * @param n
     * @return
     */
    public int dpUniquePathsOPT(int m, int n) {
        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }

        return dp[m - 1];
    }

}
