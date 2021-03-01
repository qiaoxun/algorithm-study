package com.study.unclassified;

import org.junit.Test;


/**
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    @Test
    public void test() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        } else {
            String cas = countAndSay(n - 1);
            char pre = cas.charAt(0);
            int num = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < cas.length(); i++) {
                char c = cas.charAt(i);
                if (c == pre) {
                    num ++;
                } else {
                    stringBuilder.append(num + String.valueOf(pre));
                    num = 1;
                    pre = c;
                }

                if (i == cas.length() - 1) {
                    stringBuilder.append(num + String.valueOf(pre));
                }
            }
            return stringBuilder.toString();
        }
    }

}
