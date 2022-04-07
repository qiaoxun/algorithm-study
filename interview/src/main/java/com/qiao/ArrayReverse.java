package com.qiao;

import java.util.Arrays;

public class ArrayReverse {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i < j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));
    }

}
