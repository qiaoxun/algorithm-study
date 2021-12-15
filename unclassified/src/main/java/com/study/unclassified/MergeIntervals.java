package com.study.unclassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = new int[][]{{1,4},{15,18}};
//        int[][] intervals = new int[][]{{1,4},{4,5}};
//        int[][] intervals = new int[][]{{1,4},{0,5}};
//        int[][] intervals = new int[][]{{1,4},{0,1}};
//        int[][] intervals = new int[][]{{1,4},{2,3}};
//        int[][] intervals = new int[][]{{1,4},{0,0}};
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18},{0,0}};

        int[][] result = merge(intervals);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int len = intervals.length;

        if (len == 1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int[] arr = intervals[i];
            if (arr[0] > end) {
                result.add(new int[] {start, end});
                start = arr[0];
            } else if (start > arr[0]){
                start = arr[0];
            }
            if (end < arr[1]) {
                end = arr[1];
            }
        }
        result.add(new int[] {start, end});
        return result.toArray(new int[1][]);
    }

}
