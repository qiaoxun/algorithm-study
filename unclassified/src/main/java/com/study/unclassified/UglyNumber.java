package com.study.unclassified;

import org.junit.Test;

/**
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

    @Test
    public void test() {
        System.out.println(8 / 2);
        System.out.println(6 % 2);
        System.out.println(isUgly(6));
        System.out.println(isUgly(14));
    }

    public boolean isUgly(int num) {
        while (num != 1) {
            int temp = num;
            if (num % 2 == 0) {
                num /= 2;
            }
            if (num % 3 == 0) {
                num /= 3;
            }
            if (num % 5 == 0) {
                num /= 5;
            }
            if (temp == num) {
                break;
            }
        }
        return num == 1;
    }

}
