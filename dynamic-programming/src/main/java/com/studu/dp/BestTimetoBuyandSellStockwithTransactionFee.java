package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

public class BestTimetoBuyandSellStockwithTransactionFee {

    @Test
    public void test() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices1 = {1,3,7,5,10,3};
        int[] prices2 = {4,5,2,4,3,3,1,2,5,4};
        int fee = 2;
        System.out.println(maxProfit1(prices, fee));
        System.out.println(maxProfit1(prices1, 3));
        System.out.println(maxProfit1(prices2, 1));
    }

    public int maxProfit(int[] prices, int fee) {
        /**
         * 0 - hold
         * 1 - sell
         */
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i] - fee;
            maxPro = Math.max(maxPro, dp[i][1]);
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return maxPro;
    }

    public int maxProfit1(int[] prices, int fee) {
        /**
         * 0 - hold: 1 昨天也持有，2 昨天卖掉，今天持有，3 昨天空闲，今天持有
         * 1 - sell: 1 昨天持有，今天卖出
         * 2 - rest: 1 昨天卖出， 2 昨天空闲
         */
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

//        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][2] - prices[i]);

            dp[i][1] = dp[i - 1][0] + prices[i] - fee;

            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);

//            maxPro = Math.max(maxPro, dp[i][1]);
//            maxPro = Math.max(maxPro, dp[i][2]);
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
