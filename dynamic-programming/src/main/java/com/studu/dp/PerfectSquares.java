package com.studu.dp;

import org.junit.Test;

public class PerfectSquares {

    @Test
    public void test() {
        System.out.println(numSquares(12));
    }

    public int numSquares(int n) {

        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, numSquares(n - i * i) + 1);
        }
        return res;
    }
}
