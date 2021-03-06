package com.study.unclassified;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses {

    @Test
    public void test() {
        String s = "((())))()";
//        String s = "((())))()())))(((()()(())))";
//        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParenthesesDP(s));
    }

    /**
     * 1. 暴力求解
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int sLength = s.length();
        int maxLength = 0;
        for (int i = 0; i < sLength; i++) {
            for (int j = i + 1; j < sLength; j += 2) {
                if (isValid(s.substring(i, j + 1))) {
                    int tempLength = j - i + 1;
                    maxLength = maxLength > tempLength ? maxLength : tempLength;
                }
            }
        }
        return maxLength;
    }

    @Test
    public void testIsValid() {
        String str = "()()((())";
        System.out.println(isValid(str));
    }

    private boolean isValid(String str) {
        int strLength = str.length();
        char left = '(';
        char right = ')';
        if (str.charAt(0) == right) {
            return false;
        }
        Stack<Character> braceStack = new Stack<>();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (c == left) {
                braceStack.push(c);
            } else if (c == right) {
                if (braceStack.isEmpty()) {
                    return false;
                }
                braceStack.pop();
            }
        }

        return braceStack.size() == 0;
    }

    /**
     * 动态规划求解
     */

    public int longestValidParenthesesDP(String s) {
        int sLength = s.length();
        int dp[] = new int[sLength];
        int maxLength = 0;
        for (int i = 1; i < sLength; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    System.out.println("i = " + i + ", dp[i - 1]= " + dp[i - 1]);
                    if (i - dp[i - 1] - 2 > 0) {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                maxLength = maxLength > dp[i] ? maxLength : dp[i];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return maxLength;
    }

}
