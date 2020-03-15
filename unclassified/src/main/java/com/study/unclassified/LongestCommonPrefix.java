package com.study.unclassified;

import org.junit.Test;

public class LongestCommonPrefix {

    @Test
    public void test() {
        String[] strs = {"flower","flow","flight"};
        String[] strs1 = {"dog","racecar","car"};
        String[] strs2 = {};
        String[] strs3 = {""};
        String[] strs4 = {"a"};
        String[] strs5 = {"b", "c"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
        System.out.println(longestCommonPrefix(strs4));
        System.out.println(longestCommonPrefix(strs5));
        System.out.println("======");
    }

    @Test
    public void test1() {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder commonPre = new StringBuilder();
        int num = 0;

        out:
        while (true) {
            String current = "";
            for (String str : strs) {
                if (str.length() == 0 || str.length() <= num) {
                    break out;
                }
                if (current.equals("")) {
                    current = str.substring(num, num + 1);
                } else if (!current.equals(str.substring(num, num + 1))) {
                    break out;
                }
            }
            commonPre.append(current);
            num++;
        }
        return commonPre.toString();
    }
}
