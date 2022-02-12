package com.study.unclassified;

public class MissingNumbers {

    /**
     * 已知int[]  array里所有成员都是>=5000 且<= 10000，
     * 求5000-10000里没有在array里出现的数字。(尽量写出时间复杂度最好的代码) （30分）
     */
    public void missingNumbers1(int[] array) {
        int[] tempArr = new int[5000];
        for (int x : array) {
            tempArr[x - 5000] = x;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * 已知int[]  array里所有成员都是>=5000 且<= 10000。数组里值有序且唯一，
     * 求5000-10000里没有在array里出现的数字。(尽量写出时间和空间复杂度最好的代码) （30分）
     * @param array
     */
    public void missingNumbers2(int[] array) {
        for (int i = 5000; i <= 10000; i++) {
            if (array[i - 5000] != i) {
                System.out.println(i);
            }
        }
    }

    /**
     * 已知 int[]  array里所有成员都是>=5000 且<= 10000。数组里值有序且唯一。
     * array里只缺少一个值。
     * 求5000-10000里没有在array里出现的数字。(尽量写出时间和空间复杂度最好的代码)
     * @param array
     */
    public void missingNumbers3(int[] array) {
        binarySearch(array, 0, array.length);
    }

    public void binarySearch(int[] array, int left, int right) {
        if (left == right) {
            System.out.println(array[left]);
            return;
        }
        int mid = (left + right) / 2;
        if (array[mid] == mid + 5000) {
            left = mid;
        } else {
            right = mid;
        }
        binarySearch(array, left, right);
    }

}
