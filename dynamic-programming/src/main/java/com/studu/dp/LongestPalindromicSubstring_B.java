package com.studu.dp;

import org.junit.Test;

public class LongestPalindromicSubstring_B {

    @Test
    public void test() {
//        String str = "abaccdcca";
//        String str1 = "cbbd";
//        String str2 = "babad";
//        String str3 = "abc";
//        String str4 = "aaaaaa";
        String str5 = "abcda";
        String str6 = "babad";
//        System.out.println(longestPalindrome(str));
//        System.out.println(longestPalindrome(str1));
//        System.out.println(longestPalindrome(str2));
//        System.out.println(longestPalindrome(str3));
//        System.out.println(longestPalindrome(str4));
        System.out.println(longestPalindrome(str5));
        System.out.println(longestPalindrome(str6));
    }

    public String longestPalindrome(String s) {
        if (null == s || s.equals("")) return "";
        char[] chars = s.toCharArray();

        String longestStr = new String(chars, 0, 1);
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && judgeIfStringIsPalindromic(chars, i, j)) {
                    if (longestStr.length() < j - i + 1) {
                        longestStr = new String(chars, i, j - i + 1);
                    }
                }
            }
        }
        return longestStr;
    }

    private boolean judgeIfStringIsPalindromic(char[] chars, int left, int right) {
        if (right - left == 1) return true;

        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }

        return true;
    }


    @Test
    public void test1() {
//        String str = "abaccdcca";
//        String str1 = "cbbd";
//        String str2 = "babad";
//        String str3 = "abc";
//        String str4 = "aaaaaa";
        String str5 = "abcda";
        String str6 = "babad";
//        System.out.println(longestPalindrome(str));
//        System.out.println(longestPalindrome(str1));
//        System.out.println(longestPalindrome(str2));
//        System.out.println(longestPalindrome(str3));
//        System.out.println(longestPalindrome(str4));
        System.out.println(longestPalindrome(str5));
        System.out.println(longestPalindrome(str6));
    }




}
