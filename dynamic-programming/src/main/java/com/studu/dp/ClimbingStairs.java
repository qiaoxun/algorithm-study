package com.studu.dp;

import org.junit.Test;

public class ClimbingStairs {

    @Test
    public void test() {
        System.out.println(climbStairs_DP(2));
        System.out.println(climbStairs_BF(2));
        System.out.println(climbStairs1(2));
        System.out.println(climbStairs_DP(3));
        System.out.println(climbStairs_DP(3));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs_DP(4));
        System.out.println(climbStairs_BF(4));
        System.out.println(climbStairs1(4));
    }

    /**
     * Brute Force
     * @param n
     * @return
     */
    public int climbStairs_BF(int n) {
        if (n <= 2) return n;
        return climbStairs_BF(n - 1) + climbStairs_BF(n - 2);
    }

    /**
     * Brute Force
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    /**
     * DP
     * @param n
     * @return
     */
    public int climbStairs_DP(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
