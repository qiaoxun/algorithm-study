package com.studu.dp;

import org.junit.Test;

public class ContainerWithMostWater {

    @Test
    public void test() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
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

}
