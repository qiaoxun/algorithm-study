package com.studu.dp;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * https://www.zhihu.com/question/40965749
 */
public class LongestPalindrome {


    @Test
    public void test() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String result = longestPalindrome.longestPalindromeSubstring("cbbd");
        System.out.println(result);
    }

    public String longestPalindromeSubstring(String str) {
        if (str == null || "".equals(str)) return "";
        int strLength = str.length();

        String maxStr = str.substring(0, 1);
        for (int i = 0; i < strLength; i++) {
            char charI = str.charAt(i);
            for (int j = i + 1; j < strLength; j++) {
                char charJ = str.charAt(j);
                if (charI == charJ) {
                    if (judgeIfStrIsPalindrome(str, i, j)) {
                        if (maxStr.length() < (j - i + 1)) {
                            maxStr = str.substring(i, j + 1);;
                        }
                    }
                }
            }
        }
        return maxStr;
    }

    @Test
    public void testJudge() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        boolean result = longestPalindrome.judgeIfStrIsPalindrome("abda", 0, 2);
        System.out.println(result);
    }

    private boolean judgeIfStrIsPalindrome(String str, int left, int right) {
        int subStrLength = right - left;
        if (subStrLength == 0 || subStrLength == 1) return true;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++; right--;
        }

        return true;
    }



}
