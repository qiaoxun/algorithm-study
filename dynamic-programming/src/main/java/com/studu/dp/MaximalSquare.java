package com.studu.dp;

import org.junit.Test;


public class MaximalSquare {

    @Test
    public void test() {
        char[] char0 = {'1', '0', '1', '0', '0'};
        char[] char1 = {'1', '0', '1', '1', '1'};
        char[] char2 = {'1', '1', '1', '1', '1'};
        char[] char3 = {'1', '0', '0', '1', '0'};
        char[][] matrix = {char0, char1, char2, char3};
        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare1(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int a = matrix.length;
        int b = matrix[0].length;

        int[][] dp = new int[a][b];
        int max = 0;

        for (int i = 0; i < a; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = max > dp[i][0] ? max : dp[i][0];
        }

        for (int i = 0; i < b; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;;
            max = max > dp[0][i] ? max : dp[0][i];
        }

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int miniNum = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = (int)Math.pow(Math.pow(miniNum, 0.5) + 1, 2);
                    max = max > dp[i][j] ? max : dp[i][j];
                }
            }
        }
        return max;
    }


    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int a = matrix.length;
        int b = matrix[0].length;

        int[] dp = new int[b];
        int max = 0;

        for (int i = 0; i < b; i++) {
            dp[i] = matrix[0][i] == '0' ? 0 : 1;;
            max = max > dp[i] ? max : dp[i];
        }

        int temp = 0;

        for (int i = 1; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == '0') {
                    temp = dp[j];
                    dp[j] = 0;
                } else {
                    if (j == 0) {
                        temp = dp[j];
                        dp[j] = 1;
                    } else {
                        int miniNum = Math.min(Math.min(dp[j], dp[j - 1]), temp);
                        temp = dp[j];
                        dp[j] = (int)Math.pow(Math.pow(miniNum, 0.5) + 1, 2);
                    }
                    max = max > dp[j] ? max : dp[j];
                }
            }
        }
        return max;
    }

}
