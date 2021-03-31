package com.study.unclassified;

import org.junit.Test;

public class MultiplyStrings {

    @Test
    public void test() {
        String num1 = "99";
        String num2 = "99";
        System.out.println(multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();

        int[] ansArr = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int result = x * y;
                ansArr[i + j + 1] += result;
            }
        }

        StringBuffer resultSb = new StringBuffer();

        for (int i = ansArr.length - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] = ansArr[i] % 10;
            resultSb.append(ansArr[i]);
        }

        if (ansArr[0] != 0) {
            resultSb.append(ansArr[0]);
        }

        return resultSb.reverse().toString();
    }


    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        String result = "0";
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int re = x * y;
                int zeroNum = len1 - 1 - i + len2 - 1 - j;

                StringBuffer zeros = new StringBuffer();
                for (int k = 0; k < zeroNum; k++) {
                    zeros.append("0");
                }
                result = addStrings(result, re + zeros.toString());
            }
        }
        return result;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() -  1, j = num2.length() - 1, add = 0;
        StringBuffer stringBuffer = new StringBuffer();

        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            stringBuffer.append(result % 10);

            add = result / 10;

            i--;
            j--;
        }
        return stringBuffer.reverse().toString();
    }


}
