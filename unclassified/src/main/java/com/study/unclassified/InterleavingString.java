package com.study.unclassified;

public class InterleavingString {

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
//        String s1 = "aa";
        String s1 = "aabcc";
//        String s2 = "ab";
        String s2 = "dbbca";
        System.out.println(interleavingString.isInterleave(s1, s2, "aadbbcbcac"));
        System.out.println(interleavingString.isInterleave(s1, s2, "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i-1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j-1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }



    /**
     * Wrong Answer
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return s2.equals(s3);
        }

        if (s2.length() == 0) {
            return s1.equals(s3);
        }

        int s1Index = 0;
        int s2Index = 0;
        int switch1And2;
        if (s1.length() > 0 && s3.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
            switch1And2 = 1;
        } else {
            switch1And2 = 2;
        }
        boolean should1 = switch1And2 == 1;
        boolean should2 = !should1;
        for (int i = 0; i < s3.length(); i++) {
            char c = s3.charAt(i);
            if (switch1And2 == 1) {
                if (s1Index < s1.length() && s1.charAt(s1Index) == c) {
                    s1Index++;
                    should1 = false;
                } else {
                    if (should1) {
                        return false;
                    }
                    should2 = true;
                    switch1And2 = 2;
                }
            }
            if (switch1And2 == 2) {
                if (s2Index < s2.length() && s2.charAt(s2Index) == c) {
                    s2Index++;
                    should2 = false;
                } else {
                    if (should2) {
                        return false;
                    }
                    i = i - 1;
                    switch1And2 = 1;
                    should1 = true;
                }
            }
        }
        return true;
    }

}
