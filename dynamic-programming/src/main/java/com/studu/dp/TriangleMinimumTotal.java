package com.studu.dp;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 */
public class TriangleMinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> each = triangle.get(i);
            sum += findMinimumNum(each);
        }
        return sum;
    }

    public int findMinimumNum(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        int minimum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (minimum > list.get(i)) {
                minimum = list.get(i);
            }
        }
        return minimum;
    }
}
