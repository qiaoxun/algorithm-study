package com.studu.dp;

import org.junit.Test;

public class IsSubsequence {

    @Test
    public void test() {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || "".equals(s)) return true;
        char[] sourceChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        int sIndex = 0;
        for (int i = 0; i < targetChars.length; i++) {
            if (targetChars[i] == sourceChars[sIndex]) {
                sIndex++;
                if (sIndex == sourceChars.length)
                    return true;
            }
        }
        return false;
    }
}
