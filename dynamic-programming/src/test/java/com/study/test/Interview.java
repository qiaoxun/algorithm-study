package com.study.test;

import org.junit.Test;

import java.util.LinkedHashSet;

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

}
