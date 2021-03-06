package com.studu.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 所谓递归，便是把大问题”分治“成类似的小问题。
 * 假设，a 的长度是 m，b 的长度是 n，要求 a[1]a[2]...a[m] => b[1]b[2]...b[n] 的最小编辑距离，记为 d[m][n]。
 *
 * 如果 a[m] === b[n]，那么问题转化为求解：a[1]a[2]...a[m-1] => b[1]b[2]...b[n-1] 的最小编辑距离，因此 d[m][n] === d[m-1][n-1]。比如，"xyz" => "pqz" 的最小编辑距离等于 "xy" => "pq" 的最小编辑距离。
 * 如果 a[m] !== b[n]，又分为三种情况：
 * 比如，"xyz" => "efg" 的最小编辑距离等于 "xy" => "efg" 的最小编辑距离 + 1（因为允许插入操作，插入一个 "z"），抽象的描述便是 d[m][n] === d[m-1][n] + 1。
 * 比如，"xyz" => "efg" 的最小编辑距离等于 "xyzg" => "efg" 的最小编辑距离 + 1，且因为最后一个字符都是 "g"，根据第一个判断条件，可以再等于 "xyz" => "ef" 的最小编辑距离 + 1，因此，得到结论："xyz" => "efg" 的最小编辑距离等于 "xyz" => "ef" 的最小编辑距离 + 1，抽象的描述便是：d[m][n] === d[m][n-1] + 1。
 * 比如，"xyz" => "efg" 的最小编辑距离等于 "xyg" => "efg" 的最小编辑距离 + 1（因为允许替换操作，可以把 "g" 换成 "z"），再等于 "xy" => "ef" 的编辑距离 + 1（根据第一个判断条件），抽象的描述便是： d[m][n] === d[m-1][n-1] + 1。
 * 上述三种情况都有可能出现，因此，取其中的最小值便是整体上的最小编辑距离。
 * 如果 a 的长度为 0，那么 a => b 的最小编辑距离为 b 的长度；反过来，如果 b 的长度为 0，那么 a => b 的最小编辑距离为 a 的长度
 * https://github.com/youngwind/blog/issues/106
 */
public class MinDistance {

    @Test
    public void test() {
        String str1 = "kitten";
        String str2 = "sitting";

        MinDistance minDistance = new MinDistance();
        System.out.println("minDistanceDP = " + minDistance.minDistanceDP(str1, str2));
        System.out.println("minDistanceDPOPT = " + minDistance.minDistanceDPOPT(str1, str2));
    }

    public int minDistanceDP(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 == 0 && length2 == 0) {
            return 0;
        }

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 1. replace
                    int a = dp[i - 1][j - 1] + 1;
                    // 2. insert
                    int b = dp[i][j - 1] + 1;
                    // 3. delete
                    int c = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(Math.min(a, b), c);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return dp[length1][length2];
    }

    public int minDistanceDPOPT(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        int[] dp = new int[length2 + 1];

        for (int i = 0; i <= length2; i++) {
            dp[i] = i;
        }

        int temp = 0;

        for (int i = 1; i <= length1; i++) {
            temp = dp[0];
            dp[0] = i;
            for (int j = 1; j <= length2; j++) {
                // dp[i -1][j - 1]
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    System.out.println("temp = " + temp);
                    int pre = dp[j];
                    dp[j] = temp;
                    temp = pre;
                } else {
                    int a = dp[j - 1] + 1;
                    int b = dp[j] + 1;
                    int c = temp + 1;
                    temp = dp[j];
                    dp[j] = Math.min(Math.min(a, b), c);
                }

            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[length2];
    }

    public int minDistanceDPOPT2(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        int[] dp = new int[length2 + 1];

        for (int i = 0; i <= length2; i++) {
            dp[i] = i;
        }

        int temp = 0;

        for (int i = 1; i <= length1; i++) {
            temp = dp[0];
            dp[0] = i;
            for (int j = 1; j <= length2; j++) {
                // dp[i -1][j - 1]
                int pre = temp;
                // dp[i - 1][j]
                temp = dp[j];
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = pre;
                } else {
                    int a = dp[j - 1] + 1;
                    int b = temp + 1;
                    int c = pre + 1;
                    dp[j] = Math.min(Math.min(a, b), c);
                }
            }
        }
        return dp[length2];
    }

}
