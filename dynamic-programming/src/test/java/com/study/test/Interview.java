package com.study.test;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Stack;

public class Interview {

    @Test
    public void test1() {
        Interview interview = new Interview();
        interview.filterSameCharacter("AAaaBbbBccDAd");
    }

    public String filterSameCharacter(String str) {
        LinkedHashSet set = new LinkedHashSet();
        int strLength = str.length();
        String temp = "";
        for (int i = 0; i < strLength; i++) {
            String s = str.substring(i, i + 1);
            if (!set.contains(s) && !set.contains(s.toUpperCase()) && !set.contains(s.toLowerCase())) {
                set.add(s);
            }
        }
        System.out.println(set);
        return "";
    }

    /**
     * 有效括号
     * 给定一个只包括 '('，')'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
     * 示例 1:
     * 输入: "(())"
     * 输出: true
     *
     *  实例 2：
     *  输入: "())("
     * 输出: false
     */

    @Test
    public void test2() {
        String str = ")(";
//        System.out.println(isStrValid(str));
        System.out.println(isStrValid2(str));
    }

    public boolean isStrValid(String str) {
        int strLength = str.length();
        char left = '(';
        char right = ')';
        Stack<Character> braceStack = new Stack<>();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (c == left) {
                braceStack.push(c);
            } else if (c == right) {
                braceStack.pop();
            }
        }

        return braceStack.size() == 0;
    }


    public boolean isStrValid2(String str) {
        int strLength = str.length();
        char left = '(';
        char right = ')';
        int sum = 0;
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (c == left) {
                sum ++;
            } else if (c == right) {
                sum --;
            }
        }
        return sum == 0;
    }



}
