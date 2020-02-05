package com.studu.dp;

import org.junit.Test;

public class DecodeWays {

    @Test
    public void test() {
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("270"));
        System.out.println(numDecodings("2000"));
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            if (chars[0] > '0') return 1;
            else return 0;
        }

        int sum = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] < '3' && chars[i - 1] != '0' && chars[i] < '7' && chars[i] == '0' && i != chars.length - 1) {
                sum++;
            }
        }
        return sum;
    }

    public int numDecodings_DP(String s) {

        return 0;
    }

}
