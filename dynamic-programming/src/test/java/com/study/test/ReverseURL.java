package com.study.test;

import org.junit.Test;

import java.util.Stack;

public class ReverseURL {

    @Test
    public void reverse() {
        String url = "www.toutiao.com";

        String[] arr = url.split("\\.");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            String each = stack.pop();
            stringBuilder.append(each);
            if (i != arr.length - 1) {
                stringBuilder.append(".");
            }
        }

        System.out.println(stringBuilder);
    }

    @Test
    public void reverse1() {
        String url = "www.toutiao.com.eee";

        String[] arr = url.split("\\.");

        int left = 0;
        int right = arr.length - 1;
        while (true) {
            if (right > left) {
                String leftStr = arr[left];
                arr[left] = arr[right];
                arr[right] = leftStr;
            } else {
                break;
            }
            left++;
            right--;
            System.out.println("left " + left);
        }

        System.out.println(String.join(".", arr));

    }

}
