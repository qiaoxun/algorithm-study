package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown {

    @Test
    public void test() {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][3];

        /**
         *  0 - sold
         *  1 - hold
         *  2 - rest
         */
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][1] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
