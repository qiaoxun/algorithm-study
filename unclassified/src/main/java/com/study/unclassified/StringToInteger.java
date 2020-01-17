package com.study.unclassified;

import org.junit.Test;

public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        char plus = '+';
        char minus = '-';
        int sign = 1;
        int start = 0;
        int res = 0;
        char[] chars = str.toCharArray();

        if (chars[0] == plus) {
            start++;
        } else if (chars[0] == minus) {
            sign = -1;
            start++;
        }

        boolean findNum = false;

        for (int i = start; i < chars.length; i++) {
            char currentChar = chars[i];
            if (Character.isDigit(currentChar)) {
                findNum = true;
                int num = currentChar - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + num;
            } else {
                if (!findNum) {
                    return 0;
                } else {
                    break;
                }
            }
        }
        res *= sign;
        return res;
    }

    public int myAtoi1(String str) {
        /* check if the string is empty */
        if(str.length() == 0)
            return 0;

        int curr=0, sign = 1, res = 0;

        /* check for whitespaces */
        for(int i=0;i<str.length();i++)
        {
            if( str.charAt(i) == ' ' )
                curr++;

            else break;
        }

        /* if no integers exist in the string */
        if(curr == str.length())
            return 0;

        /* handle '+' sign */
        if(str.charAt(curr) == '-')
        {sign = -1; curr++;}

        /* handle '-' sign */
        else if(str.charAt(curr) == '+')
        { sign = 1; curr++;}

        /* check if first non-white space character is not a digit (see Eg. 4 in description) */
        else if( !Character.isDigit(str.charAt(curr)))
            return 0;

        /* convert substring of numbers to integers       */
        for(int i = curr; i<str.length() ;i++)
        {
            char ch = str.charAt(i);

            if( Character.isDigit(ch) )
            {
                int num = ch - '0';

                /* check for overflow */
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && num >7))
                    return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;

                res = (res * 10) + num;
            }

            else break;
        }

        return sign * res;

    }

    @Test
    public void test() {
        String str = "-+3aaa";
        System.out.println(myAtoi(str));
        System.out.println(myAtoi1(str));
    }

}
