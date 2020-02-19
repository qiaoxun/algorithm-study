package com.studu.dp;

import org.junit.Test;

public class BestTimeToBuyAndSellStock {

    @Test
    public void test() {
        int prices[] = {7,1,5,3,6,4};
        int prices1[] = {7,6,4,3,1};
        int prices2[] = {7,1,5,3,0,6,4};
        int prices3[] = {1,2};
        int prices4[] = {1,2, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit1(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit1(prices2));
        System.out.println(maxProfit(prices3));
        System.out.println(maxProfit1(prices3));
        System.out.println(maxProfit(prices4));
        System.out.println(maxProfit1(prices4));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxSum = 0;
        int left = 0;
        int right = 1;
        while (left < prices.length) {
            if (prices[right] <= prices[left]) {
                left = right;
                right = left + 1;
            } else {
                maxSum = Math.max(maxSum, prices[right] - prices[left]);
                right++;
            }

            if (right > prices.length - 1) {
                left++;
                right = left + 1;
                if (right == prices.length) break;
            }
        }
        return maxSum;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int miniNum = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - miniNum > 0) {
                maxProfit = maxProfit < prices[i] - miniNum ? prices[i] - miniNum : maxProfit;
            } else {
                miniNum = prices[i];
            }
        }
        return maxProfit;
    }

}
