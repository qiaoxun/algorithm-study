package com.study.unclassified;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(6));
        System.out.println(climbingStairs.climbStairs1(6));
        System.out.println(climbingStairs.climbStairsDP(6));
        System.out.println(climbingStairs.climbStairsDP1(6));
    }

    public int climbStairsDP1(int n) {
        int pre1 = 0;
        int pre2 = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                pre2 = 1;
            } else if (i == 2) {
                pre1 = 2;
            } else {
                result = pre1 + pre2;
                pre2 = pre1;
                pre1 = result;
            }
        }
        return result;
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n < 0) return 0;
        int[] memo = new int[n + 1];
        if (memo[n] > 0) {
            return memo[n];
        }

        if (n == 1) {
            memo[n] = 1;
            return 1;
        }

        if (n == 2) {
            memo[n] = 2;
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public int climbStairs1(int n) {
        if (n < 0) return 0;
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


}
