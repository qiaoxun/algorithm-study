package com.qiao;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 */
public class ThreeSumWithMultiplicity {

    public static void main(String[] args) {
        ThreeSumWithMultiplicity threeSumWithMultiplicity = new ThreeSumWithMultiplicity();
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        int result = threeSumWithMultiplicity.threeSumMulti(arr, target);
        System.out.println(result);
    }

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
