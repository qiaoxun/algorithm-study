package com.study.unclassified;

import org.junit.Test;

import java.util.Stack;

public class ValidParentheses {

    @Test
    public void test() {
        String s = "()";
        String s1 = "()[]";
        String s2 = "()[]{}";
        String s3 = "({[]}))[]{}";
        String s4 = "(]";
        String s5 = "{[]}";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            if (stack.size() > 0 && ch.equals(getPair(stack.peek()))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.size() == 0)
            return true;
        return false;
    }

    private String getPair(String s) {
        if (s.equals("(")) {
            return ")";
        } else if (s.equals("{")) {
            return "}";
        } else if (s.equals("[")) {
            return "]";
        }
        return "";
    }

}
