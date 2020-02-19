package com.study.unclassified;

import org.junit.Test;

public class RomanToInteger {

    @Test
    public void test() {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int sum = 0;
        char[] romanChars = s.toCharArray();
        char before = ' ';
        for (int i = 0; i < romanChars.length; i++) {
            char c = romanChars[i];
            int represent = getRomanRepresent(c);
            sum += getRomanRepresent(c);

            if ((c == 'V' || c =='X') && before == 'I') {
                sum -= 2;
            } else if((c == 'L' || c == 'C') && before == 'X') {
                sum -= 20;
            } else if((c == 'D' || c == 'M') && before == 'C') {
                sum -= 200;
            }

            before = c;
        }
        return sum;
    }

    private Integer getRomanRepresent(Character romanCharacter) {
        switch (romanCharacter) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
