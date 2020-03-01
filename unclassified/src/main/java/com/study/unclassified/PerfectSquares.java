package com.study.unclassified;

import org.junit.Test;

public class PerfectSquares {

    @Test
    public void test() {
//        System.out.println(Math.sqrt(3));
        System.out.println(numSquares(12));
        System.out.println(numSquares(17));
    }

    public int numSquares(int n) {
        int val = (int) Math.sqrt(n);
        if (val * val == n) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, numSquares(n - i * i) + 1);
            System.out.println(i);
        }
        return res;
    }

    public int numSquares1(int n) {
        int[] memo = new int[n];
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
            res = Math.min(res, numSquares(n - i * i) + 1);
            System.out.println(i);
        }
        return memo[n] = res;
    }

}
