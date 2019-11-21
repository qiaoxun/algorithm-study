package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePaths2 {

    @Test
    public void test() {
//        int[][] obstacleGrid = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
        int[][] obstacleGrid = {{1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLength = obstacleGrid.length;
        int columnLength = obstacleGrid[0].length;

        int[][] dp = new int[rowLength][columnLength];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        // 初始化
        for (int i = 1; i < rowLength; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < columnLength; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        for (int i = 0; i < rowLength; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[rowLength - 1][columnLength - 1];
    }

}
