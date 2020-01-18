package com.study.unclassified;

import org.junit.Test;

public class ContainerWithMostWater {

    /**
     *  ---------------------- brute force ---------------------------
     */
    @Test
    public void test() {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
        System.out.println(maxArea1(height));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
                max = max > area ? max : area;
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = 0;
            if (height[left] > height[right]) {
                area = height[right] * (right - left);
                right--;
            } else {
                area = height[left] * (right - left);
                left++;
            }
            max = max > area ? max : area;

        }
        return max;
    }



}
