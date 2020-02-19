package com.study.unclassified;

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test() {
        int x = 1534236469;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(x));
    }

    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int reverseX = 0;
        while (x > 0) {
            int nextValue = x % 10;
            if (reverseX > Integer.MAX_VALUE / 10 || (reverseX == Integer.MAX_VALUE / 10  && nextValue > 7)) {
                return 0;
            }
            reverseX = reverseX * 10 + nextValue;
            x = x / 10;
        }
        return reverseX * sign;
    }

}
