package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock_1 {

    @Test
    public void test() {
        int[] prices = {7,1,5,3,6,4};
        int[] prices1 = {7,6,4,3,1};
        int prices2[] = {7,1,5,3,0,6,4};
        int prices3[] = {1,2};
        int prices4[] = {1,2, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
        System.out.println(maxProfit(prices4));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minimumNum = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price > minimumNum) {
                maxProfit = price - minimumNum > maxProfit ? price - minimumNum : maxProfit;
            } else {
                minimumNum = price;
            }
        }

        return maxProfit;
    }
}
