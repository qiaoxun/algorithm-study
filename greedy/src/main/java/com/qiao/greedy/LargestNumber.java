package com.qiao.greedy;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums1 = {10, 2};
        int[] nums2 = {3,30,34,5,9};

    }

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String maxNum = String.valueOf(nums[i]);
            int maxNumIndex = i;
            for (int j = i; j < nums.length; j++) {
                String currentNumStr = String.valueOf(nums[j]);
                maxNum = compareAndReturnLarger(maxNum, currentNumStr);
                if (currentNumStr == maxNum) {
                    maxNumIndex = j;
                }
            }
            list.add(maxNum);
            if (i != maxNumIndex) {
                int temp = nums[i];
                nums[i] = nums[maxNumIndex];
                nums[maxNumIndex] = temp;
            }
        }
        if (list.get(0).equals("0")) {
            return "0";
        }
        return String.join("", list);
    }

    private String compareAndReturnLarger(String num1, String num2) {

        String op1 = num1 + num2;
        String op2 = num2 + num1;

        int length = op1.length();

        for (int j = 0; j < length; j++) {
            char c1 = op1.charAt(j);
            char c2 = op2.charAt(j);
            if (c1 > c2) {
                return num1;
            } else if (c2 > c1) {
                return num2;
            }
        }

        return num1;
    }}
