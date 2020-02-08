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
        System.out.println("20000 " + numDecodings("20000"));
//        char a = 1;
//        char b = '0';
//        char c = ' ';
//        System.out.println(a == b);
//        System.out.println(a < b);
//        System.out.println(b < c);
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            if (chars[0] > '0') return 1;
            else return 0;
        }

        char first = chars[0];
        char second = chars[1];

        if (first == '0') {
            return 0;
        }

        int sum = 0;
        if (first < '3') {
            if (second < '7' && second > '0') sum = 2;
            else if (second == '0' || second >= '7') sum = 1;
        }
        for (int i = 2; i < chars.length; i++) {
            char current = chars[i];
            if (current == '0') {
                if (second == '0' || second > '2') return 0;
            } else {
                if (current < '7') {
                    if ('0' < second && second < '3') {
                        sum++;
                    }
                }
            }
            second = current;
        }
        return sum;
    }

    public int numDecodings_DP(String s) {

        return 0;
    }

}
