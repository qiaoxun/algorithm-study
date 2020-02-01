package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum_1 {

    @Test
    public void test() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid1 = {{1},{1}};
        System.out.println(minPathSum_DP(grid));
        System.out.println(minPathSum_DP1(grid));
        System.out.println(minPathSum_BF(grid));
        System.out.println(minPathSum_BF1(grid));
        System.out.println(minPathSum_DP(grid1));
        System.out.println(minPathSum_DP1(grid1));
        System.out.println(minPathSum_BF(grid1));
        System.out.println(minPathSum_BF1(grid1));
    }

    /**
     * brute force
     * @param grid
     * @return
     */
    public int minPathSum_BF(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    public int minPathSum_BF1(int[][] grid) {
        return calculate1(grid, grid.length - 1, grid[0].length - 1);
    }

    public int calculate1(int[][] grid, int i, int j) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[i][j];
        return grid[i][j] + Math.min(calculate1(grid, i - 1, j), calculate1(grid, i, j - 1));
    }

    /**
     * DP
     *
     */
    public int minPathSum_DP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * DP
     *
     */
    public int minPathSum_DP1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        dp[0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }

        return dp[n - 1];
    }
}
