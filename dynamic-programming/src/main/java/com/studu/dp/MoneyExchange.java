package com.studu.dp;

import org.junit.Test;

/**
 * 想兑换100元钱，有1,2,5,10四种钱，问总共有多少兑换方法
 */
public class MoneyExchange {

    @Test
    public void test() {
        int[] changes = {1, 2, 5, 10};
        int total = 100;
        System.out.println(exchangeCount(changes, total, 0));
    }

    public int exchangeCount(int[] changes, int total, int index) {
        if (total == 0) return 1;

        int count = 0;
        for (int i = index; i < changes.length; i++) {
            int change = changes[i];
            if (change <= total) {
                int subCount = exchangeCount(changes, total - change, i);
                count += subCount;
            }
        }
        return count;
    }



    @Test
    public void testDP() {
        int[] changes = {1, 2, 5, 10};
        int total = 100;
        System.out.println(exchangeCountDP(changes, total));
    }

    public int exchangeCountDP(int[] changes, int total) {
        int dp[][] = new int[changes.length][total + 1];
        for (int i = 0; i < changes.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j * changes[0] <= total; j++) {
            dp[0][j * changes[0]] = 1;
        }

        for (int i = 1; i < changes.length; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= changes[i] ? dp[i][j - changes[i]] : 0);
            }
        }
        return dp[changes.length - 1][total];
    }


    @Test
    public void testCountWaysDPTwoArray() {
        int[] changes = {1, 2, 5, 10};
        int total = 100;
        System.out.println(countWaysDPTwoArray(changes, changes.length, total));
    }

    public int countWaysDPTwoArray(int[] changes, int n, int x) {
        // write code here
        //dp[i][j]表示使用changes[0~i]的钱币组成金额j的方法数
        int[][] dp = new int[n][x + 1];
        //第一列全为1，因为组成0元就只有一种方法
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        //第一行只有changes[0]的整数倍的金额才能有1种方法
        for (int j = 0; j * changes[0] <= x; j++) {
            dp[0][j * changes[0]] = 1;
        }
        //从位置(1,1)开始遍历
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= x; j++) {
                //关键：使用0~i的钱币组成j-changes[i]金额的方法数+使用0~i-1钱币组成j的方法数
                dp[i][j] = dp[i - 1][j] + (j - changes[i] >= 0 ? dp[i][j - changes[i]] : 0);
            }
        }

        return dp[n - 1][x];
    }

    @Test
    public void testDP1() {
        int[] changes = {1, 2, 5, 10};
        int total = 100;
        System.out.println(countWays(changes, changes.length, total));
    }

    public int countWays(int[] changes, int n, int x) {
        // write code here
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int change : changes) {
            for (int i = 0; i + change <= x; ++i) {
                dp[i + change] += dp[i];
            }
        }
        return dp[x];
    }
}
