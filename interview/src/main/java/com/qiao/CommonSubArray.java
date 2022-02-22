package com.qiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [g, k]
 */
public class CommonSubArray {

    public static void main(String[] args) {
        char[] arr1 = {'b', 'e', 'g', 'k', 'p'};
        char[] arr2 = {'a', 'e', 'f', 'g', 'k', 'o'};
        CommonSubArray commonSubArray = new CommonSubArray();
        // [g, k]
        System.out.println(Arrays.toString(commonSubArray.commonSubArray(arr1, arr2)));
    }

    public Character[] commonSubArray(char[] array1, char[] array2) {

        int index1 = 0;
        int index2 = 0;
        List<Character> list = new ArrayList<>();

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                list.add(array1[index1]);
                index1++;
                index2++;
            } else {
                if (list.size() > 1) {
                    break;
                }
                list.clear();
                if (array1[index1] > array2[index2]) {
                    index2++;
                } else {
                    index1++;
                }
            }
        }
        return list.toArray(new Character[1]);
    }

}
