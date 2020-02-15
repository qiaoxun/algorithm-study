package com.studu.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 */
public class TriangleMinimumTotal {

    @Test
    public void test() {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);


        List<Integer> l11 = new ArrayList<>();
        l11.add(-1);

        List<Integer> l22 = new ArrayList<>();
        l22.add(2);
        l22.add(3);

        List<Integer> l33 = new ArrayList<>();
        l33.add(1);
        l33.add(-1);
        l33.add(-3);

        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(l11);
        triangle1.add(l22);
        triangle1.add(l33);

        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal(triangle1));
    }


    /**
     * Brute Force
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int minimumSum = triangle.get(0).get(0);

        minimumSum += findMinimumTotal(triangle, 1, 0);

        return minimumSum;
    }

    public int findMinimumTotal(List<List<Integer>> triangle, int start, int position) {
        if (start == triangle.size()) return 0;

        int sumA = triangle.get(start).get(position) + findMinimumTotal(triangle, start + 1, position);
        int sumB = triangle.get(start).get(position + 1) + findMinimumTotal(triangle, start + 1, position + 1);

        return sumA < sumB ? sumA : sumB;
    }

    /**
     * DP
     */
    public int minimumTotal_DP(List<List<Integer>> triangle) {
        int minimumSum = triangle.get(0).get(0);

        minimumSum += findMinimumTotal(triangle, 1, 0);

        return minimumSum;
    }

}
