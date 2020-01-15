package com.study.unclassified;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test() {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty())
            return 0;

        char[] chars = s.toCharArray();
        Set<Character> characters = new HashSet<>();

        int maxLength = Integer.MIN_VALUE;
        int currentLength = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                char c = chars[j];
                if (characters.contains(c)) {
                    characters.clear();
                    break;
                }
                currentLength++;
                characters.add(c);
            }

            maxLength = Math.max(maxLength, currentLength);
            currentLength = 0;
        }

        return maxLength;
    }

}
