package com.study.unclassified;

import org.junit.Test;

/**
 * 一个数组中含有 1001 个元素，存放了 1,2,3...1000 和一个重复的数。只有唯一一个数是重复的，其它均只出现一次。
 * 要求设计一个算法找出这个重复的数，要求：每个数组元素只能访问一次，不用辅助存储空间。
 */
public class FindSingleNum {

    @Test
    public void test() {
        int arr[] = {1, 1, 2, 3, 2, 3, 4, 5, 5, 7, 6, 7, 6};
        System.out.println(find(arr));
    }

    public int find(int[] arr) {
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i == 1) {
                num = arr[0] ^ arr[1];
            } else {
                num = num ^ arr[i];
            }
        }
        return num;
    }

}
