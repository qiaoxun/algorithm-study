package com.studu.dp;

public class MinimumPathSum {

    public boolean isMatch(String s, String p) {
        if (!p.contains("*") && !p.contains(".")) {
            return s.equals(p);
        }

        int sLength = s.length();
        int pLength = p.length();

        for (int i = 0; i < sLength; i++) {

        }

        return false;
    }

}
