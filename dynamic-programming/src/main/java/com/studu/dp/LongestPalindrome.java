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
        String s = "sasddsas";
        String result = longestPalindrome.longestPalindromeSubstring(s);
        String result1 = longestPalindrome.longestPalindromeSubstring1(s);
        System.out.println("result = " + result);
        System.out.println("result1 = " + result1);
    }


    /**
     * 暴力解法
     * @param str
     * @return
     */
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


    /**
     * 中心扩散发
     * @param s
     * @return
     */
    public String longestPalindromeSubstring1(String s) {


        System.out.println("s is " + s);

        if (null == s || s.length() == 0)
            return "";


        if (s.length() == 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        int sLength = s.length();

        for (int i = 0; i < sLength; i++) {
            String maxSubStr = findLongestSubStr(s, i, i);
            String maxSubStr1 = "";
            if (i != sLength - 1) {
                maxSubStr1 = findLongestSubStr(s, i, i + 1);
            }

            String temp = maxSubStr.length() > maxSubStr1.length() ? maxSubStr : maxSubStr1;

            maxStr = temp.length() > maxStr.length() ? temp : maxStr;
        }

        return maxStr;
    }

    /**
     * check if the str have palindrome sub str
     * @param s
     * @param left
     * @param right
     * @return
     */
    private String findLongestSubStr(String s, int left, int right) {
        if ((right == left + 1) && s.charAt(left) != s.charAt(right)) return "";

        /**
         * left--; right++; 判断这行代码有没有执行
         */
        boolean inWhile = false;
        String maxSub = "";
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                inWhile = false;
                break;
            }

            left--; right++;
            inWhile = true;
        }
        maxSub = inWhile ? s.substring(left + 1, right) : s.substring(left, right + 1);
        return maxSub;
    }

}
