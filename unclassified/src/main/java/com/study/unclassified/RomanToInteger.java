package com.study.unclassified;

public class RomanToInteger {
    private Integer romanToInteger(String roman) {
        if (roman.equals("yi")) {
            return 1;
        }
        switch (roman) {
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            default: return 0;
        }
    }
}
