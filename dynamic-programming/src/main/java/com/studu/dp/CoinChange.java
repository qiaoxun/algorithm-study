package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {

    @Test
    public void test() {
        int[] coins = {61,268,108,481,277,439};
        int amount = 5166;
        System.out.println(coinChange(coins, amount));
    }

    /**
     * 暴力解法
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) return 0;

        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;

            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }
        return -1;
    }

    @Test
    public void testDP() {
        int[] coins = {1, 2, 5};
        int amount = 14;
        System.out.println(coinChangeDP(coins, amount));
    }

    public int coinChangeDP(int[] coins, int amount) {
        return coinChangeDP(coins, amount, new int[amount]);
    }

    private int coinChangeDP(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (count[amount - 1] != 0) return count[amount - 1];

        int minCost = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeDP(coins, amount - coin, count);
            if (res != -1) {
                minCost = Math.min(res + 1, minCost);
            }
        }
        //System.out.println("minCost is " + minCost);
        minCost = minCost == Integer.MAX_VALUE ? -1 : minCost;
        count[amount - 1] = minCost;
        return minCost;
    }

    @Test
    public void testDP2() {
        int[] coins = {1, 2, 5};
        int amount = 14;
        System.out.println(coinChangeDP1(coins, amount));
    }

    public int coinChangeDP1(int[] coins, int amount) {
        int max = amount + 1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
