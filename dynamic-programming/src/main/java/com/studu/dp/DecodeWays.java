package com.studu.dp;

import org.junit.Test;

public class DecodeWays {

    @Test
    public void test() {
        System.out.println("0 " + numDecodings("0"));
        System.out.println("00 " + numDecodings("00"));
        System.out.println("12 " + numDecodings("12"));
        System.out.println("27 " + numDecodings("27"));
        System.out.println("99 " + numDecodings("99"));
        System.out.println("999 " + numDecodings("999"));
        System.out.println("120 " + numDecodings("120"));
        System.out.println("121 " + numDecodings("121"));
        System.out.println("1270 " + numDecodings("1270"));
        System.out.println("010 " + numDecodings("010"));
        System.out.println("101 " + numDecodings("101"));
        System.out.println("10 " + numDecodings("10"));
        System.out.println("100 " + numDecodings("100"));
        System.out.println("270 " + numDecodings("270"));
        System.out.println("240 " + numDecodings("240"));
        System.out.println("220 " + numDecodings("220"));
        System.out.println("2002 " + numDecodings("2002"));
        System.out.println("2000 " + numDecodings("2000"));
        System.out.println("19963 " + numDecodings("19963"));
        System.out.println("199 " + numDecodings("199"));
        System.out.println("19 " + numDecodings("19"));
//        char a = 1;
//        char b = '0';
//        char c = ' ';
//        System.out.println(a == b);
//        System.out.println(a < b);
//        System.out.println(b < c);
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;

        int[] dp = new int[chars.length];
        dp[0] = 1;

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            char before = chars[i - 1];
            if (c == '0') {
                if (before == '1' || before == '2') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] : dp[i - 1];
                } else {
                    return 0;
                }
            } else if (before == '1') {
                dp[i] = i - 2 > 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1] + 1;
            } else if (before == '2') {
                if (c <= '6') {
                    dp[i] = i - 2 > 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[chars.length - 1];
    }

}
