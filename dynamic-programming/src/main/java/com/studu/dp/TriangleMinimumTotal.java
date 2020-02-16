package com.studu.dp;

import org.junit.Test;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 */
public class TriangleMinimumTotal {

    @Test
    public void test() {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);


        List<Integer> l11 = new ArrayList<>();
        l11.add(-1);

        List<Integer> l22 = new ArrayList<>();
        l22.add(2);
        l22.add(3);

        List<Integer> l33 = new ArrayList<>();
        l33.add(1);
        l33.add(-1);
        l33.add(-3);

        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(l11);
        triangle1.add(l22);
        triangle1.add(l33);

        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal1(triangle));
        System.out.println(minimumTotal_DP(triangle));
        System.out.println(minimumTotal_DP1(triangle));
        System.out.println(minimumTotal(triangle1));
        System.out.println(minimumTotal1(triangle1));
        System.out.println(minimumTotal_DP(triangle1));
        System.out.println(minimumTotal_DP1(triangle1));
    }


    /**
     * Brute Force
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return findMinimumTotal(triangle, 0, 0);
    }

    public int findMinimumTotal(List<List<Integer>> triangle, int level, int position) {
        if (level == triangle.size() - 1) return triangle.get(level).get(position);

        int sumA = triangle.get(level).get(position) + findMinimumTotal(triangle, level + 1, position);
        int sumB = triangle.get(level).get(position) + findMinimumTotal(triangle, level + 1, position + 1);

        return sumA < sumB ? sumA : sumB;
    }

    /**
     * Brute Force - 1 ms, 39.4 MB
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        return findMinimumTotal1(triangle, 0, 0, memo);
    }

    public int findMinimumTotal1(List<List<Integer>> triangle, int level, int position, Integer[][] memo) {
        int value = triangle.get(level).get(position);
        if (level == triangle.size() - 1) return value;

        if (memo[level + 1][position] == null) {
            memo[level + 1][position] = findMinimumTotal1(triangle, level + 1, position, memo);
        }

        if (memo[level + 1][position + 1] == null) {
            memo[level + 1][position + 1] = findMinimumTotal1(triangle, level + 1, position + 1, memo);
        }

        int sumA = value + memo[level + 1][position];
        int sumB = value + memo[level + 1][position + 1];

        return sumA < sumB ? sumA : sumB;
    }

    /**
     * DP
     * 自顶向下
     */
    public int minimumTotal_DP(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];

        dp[0][0] = triangle.get(0).get(0);
        if (len == 1) return dp[0][0];

        dp[1][0] = dp[0][0] + triangle.get(1).get(0);
        dp[1][1] = dp[0][0] + triangle.get(1).get(1);

        for (int i = 2; i < len; i++) {
            List<Integer> rowList = triangle.get(i);
            for (int j = 0, len1 = rowList.size(); j < len1; j++) {
                if (j == 0) {
                    dp[i][j] = rowList.get(j) + dp[i - 1][j];
                } else if (j == rowList.size() - 1) {
                    dp[i][j] = rowList.get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = rowList.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int ans = dp[len - 1][0];
        for (int i = 1; i < len; i++) {
            int temp = dp[len - 1][i];
            ans = ans > temp ? temp : ans;
        }

        return ans;
    }

    /**
     * DP 自底向上
     * @param triangle
     * @return
     */
    public int minimumTotal_DP1(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0, len1 = list.size(); j < len1; j++) {
                if (i == len - 1) {
                    dp[i][j] = list.get(j);
                } else {
                    dp[i][j] = list.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    /**
     * DP 自底向上
     * @param triangle
     * @return
     */
    public int minimumTotal_DP1_1(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0, len1 = list.size(); j < len1; j++) {
                if (i == len - 1) {
                    dp[j] = list.get(j);
                } else {
                    dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
