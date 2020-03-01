package com.study.unclassified;

import org.junit.Test;

public class PerfectSquares {

    @Test
    public void test() {
//        System.out.println(Math.sqrt(3));
        System.out.println(numSquares(12));
        System.out.println(numSquares1(12));
        System.out.println(numSquares_DP(12));
        System.out.println(numSquares(17));
        System.out.println(numSquares1(17));
        System.out.println(numSquares_DP(17));
    }

    public int numSquares(int n) {
        int val = (int) Math.sqrt(n);
        if (val * val == n) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, numSquares(n - i * i) + 1);
        }
        return res;
    }

    public int numSquares1(int n) {
        int[] memo = new int[n + 1];
        return calc(n, memo);
    }

    public int calc(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];

        int val = (int) Math.sqrt(n);
        if (val * val == n) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, calc(n - i * i, memo) + 1);
        }
        return memo[n] = res;
    }


    public int numSquares_DP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
