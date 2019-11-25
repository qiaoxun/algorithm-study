package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 1. 每个数组中的元素不会超过 100
 * 2. 数组的大小不会超过 200
 *
 */
public class CanPartition {

    @Test
    public void test() {
        int[] arr = {1,1,1,1,1,1};
        System.out.println(canPartition(arr));
    }

    public boolean canPartition(int nums[]) {
        int numsLength = nums.length;

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 == 1) {
            return false;
        }

        int halfSum = sum / 2;

        boolean[][] dp = new boolean[numsLength + 1][halfSum];

        dp[0][0] = true;

        for (int i = 1; i <= numsLength; i++) {
            dp[i][0] = nums[i - 1] == halfSum;
            if (dp[i][0]) return true;
        }

        for (int i = 1; i <= numsLength; i++) {
            for (int j = 0; j < halfSum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        for (int i = 1; i <= numsLength; i++) {
            for (int j = 0; j < halfSum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[numsLength][halfSum - 1];
    }

}
