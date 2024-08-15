package com.qiao.greedy;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDigits {

    public static void main(String[] args) {
        RemoveDigits auditUtil = new RemoveDigits();
        String num1 = "1432219";
        int k1 = 3;
//         1219
        String result1 = auditUtil.removeKdigits(num1, k1);
        System.out.println(result1);
        assert result1.equals("1219");
//
        String num2 = "10200";
        int k2 = 1;
        // 200

        String result2 = auditUtil.removeKdigits(num2, k2);
        System.out.println(result2);
        assert result2.equals("200");
//
//
        String num3 = "20";
        int k3 = 2;
        // 0
        String result3 = auditUtil.removeKdigits(num3, k3);
        System.out.println(result3);
        assert result3.equals("0");
//
//
        String num4 = "10001";
        int k4 = 4;
        // 0
        String result4 = auditUtil.removeKdigits(num4, k4);
        System.out.println(result4);
        assert result4.equals("0");
//
        String num5 = "10";
        int k5 = 1;
        // 0
        String result5 = auditUtil.removeKdigits(num5, k5);
        System.out.println(result5);
        assert result5.equals("0");

        String num6 = "1234567890";
        int k6 = 8;
        // 0
        String result6 = auditUtil.removeKdigits(num6, k6);
        System.out.println(result6);
        assert result6.equals("0");
    }


    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);
            if (current == '0' && stack.isEmpty()) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(current);
            } else {
                char pre = stack.peek();
                while (!stack.isEmpty() && k > 0 && pre > current) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        k--;
                        break;
                    }
                    pre = stack.peek();
                    k--;
                }
                if (!(current == '0' && stack.isEmpty())) {
                    stack.push(current);
                }
            }
        }

        int stackSize = stack.size();

        if (k >= stackSize) {
            return "0";
        }

        if (k > 0) {
            stack.setSize(stackSize - k);
        }

        String result = stack.stream().map(Object::toString).collect(Collectors.joining(""));

        return result;
    }

    public String removeKdigits1(String num, int k) {
        // 111123
        // 12345 ->  1234
        // 143229 -> 13229
        // 19001
        // 192333

//        Deque

        if (k == num.length()) {
            return "0";
        }

        for (int i = 0; i < k; i++) {
            int indexToRemove = num.length() - 1;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    indexToRemove = j;
                    break;
                }
            }
            num = num.substring(0, indexToRemove) + num.substring(indexToRemove + 1);
            num = removeHeadZeros(num);
            if (num.isEmpty()) {
                break;
            }
        }

        if (num.isEmpty()) {
            return "0";
        }
        return num;
    }

    private String removeHeadZeros(String num) {
        while (num.startsWith("0")) {
            num = num.substring(1);
        }

        return num;
    }
}
