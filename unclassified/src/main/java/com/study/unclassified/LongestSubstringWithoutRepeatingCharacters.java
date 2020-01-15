package com.study.unclassified;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test() {
        String str = "tmmzuxtt";
//        System.out.println(lengthOfLongestSubstring(str));
//        System.out.println(lengthOfLongestSubstring(str));
//        System.out.println(lengthOfLongestSubstring1(str));
//        System.out.println(lengthOfLongestSubstring2(str));
        System.out.println(lengthOfLongestSubstring3(str));
        System.out.println(lengthOfLongestSubstring4(str));
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

    /**
     * Wrong Answer  -  "dvdf"
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {

        if (s == null || s.isEmpty())
            return 0;

        char[] chars = s.toCharArray();
        Set<Character> characters = new HashSet<>();

        int maxLength = Integer.MIN_VALUE;
        int currentLength = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (characters.contains(c)) {
                currentLength = 0;
                characters.clear();
                characters.add(c);
            }
            characters.add(c);
            currentLength ++;
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    /**
     * Approach 2: Sliding Window
     *
     * Algorithm
     *
     * The naive approach is very straightforward. But it is too slow. So how can we optimize it?
     *
     * In the naive approaches, we repeatedly check a substring to see if it has duplicate character. But it is unnecessary.
     * If a substring sijs_{ij}sij​ from index iii to j−1j - 1j−1 is already checked to have no duplicate characters.
     * We only need to check if s[j]s[j]s[j] is already in the substring sijs_{ij}sij​.
     *
     * To check if a character is already in the substring, we can scan the substring, which leads to an O(n2)O(n^2)O(n2) algorithm. But we can do better.
     *
     * By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1)O(1).
     *
     * A sliding window is an abstract concept commonly used in array/string problems.
     * A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i,j)[i, j)[i,j) (left-closed, right-open).
     * A sliding window is a window "slides" its two boundaries to the certain direction. For example, if we slide [i,j)[i, j)[i,j) to the right by 111 element,
     * then it becomes [i+1,j+1)[i+1, j+1)[i+1,j+1) (left-closed, right-open).
     *
     * Back to our problem. We use HashSet to store the characters in current window [i,j)[i, j)[i,j) (j=ij = ij=i initially).
     * Then we slide the index jjj to the right. If it is not in the HashSet, we slide jjj further. Doing so until s[j] is already in the HashSet.
     * At this point, we found the maximum size of substrings without duplicate characters start with index iii. If we do this for all iii, we get our answer.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        int n = s.length();

        if (s == null || s.isEmpty())
            return 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLength = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
           if (!set.contains(chars[j])) {
               maxLength = Math.max(maxLength, j - i + 1);
               set.add(chars[j++]);
           } else {
               set.remove(chars[i++]);
           }
        }

        return maxLength;
    }


    /**
     *  not working
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;

        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(chars[i])) {
                j = Math.max(map.get(chars[i]), j);
            }
            map.put(chars[i], i + 1);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    /**
     * solution from Solution
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
