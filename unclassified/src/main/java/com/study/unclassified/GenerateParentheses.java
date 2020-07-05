package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    @Test
    public void test() {
        System.out.println(generateParenthesisBruteForce(3));
    }






    char left = '(';
    char right = ')';

    public List<String> generateParenthesisBruteForce(int n) {
        List<String> list = new ArrayList<>();
        generateAllBruteForce(new char[2 * n], 0, list);
        return list;
    }

    private void generateAllBruteForce(char[] chars, int pos, List<String> list) {
        if (pos == chars.length) {
            if (isValid(chars)) {
                list.add(new String(chars));
            }
        } else {
            chars[pos] = left;
            generateAllBruteForce(chars, pos + 1, list);
            chars[pos] = right;
            generateAllBruteForce(chars, pos + 1, list);
        }
    }

    public boolean isValid(char[] chars) {
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            char each = chars[i];
            if (each == left) {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        if (balance != 0) {
            return false;
        }
        return true;
    }

}
