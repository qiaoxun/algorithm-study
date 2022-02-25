package com.qiao;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("1.01", "1.001"));
        System.out.println(compareVersionNumbers.compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersionNumbers.compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int maxLength = arr1.length > arr2.length ? arr1.length : arr2.length;

        for (int i = 0; i < maxLength; i++) {
            int x = 0;
            int y = 0;
            if (i < arr1.length) {
                x = Integer.parseInt(arr1[i]);
            }
            if (i < arr2.length) {
                y = Integer.parseInt(arr2[i]);
            }
            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
        }
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int maxLength = arr1.length > arr2.length ? arr1.length : arr2.length;

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        if (arr1Length > arr2Length) {
            maxLength = arr1Length;
            String[] newArr2 = new String[maxLength];
            System.arraycopy(arr2, 0, newArr2, 0, arr2.length);
            arr2 = newArr2;
        } else if (arr2Length > arr1Length) {
            maxLength = arr2Length;
            String[] newArr1 = new String[maxLength];
            System.arraycopy(arr1, 0, newArr1, 0, arr1.length);
            arr1 = newArr1;
        }

        for (int i = 0; i < maxLength; i++) {
            String v1 = arr1[i] != null ? arr1[i] : "0";
            String v2 = arr2[i] != null ? arr2[i] : "0";
            int iv1 = Integer.parseInt(v1);
            int iv2 = Integer.parseInt(v2);

            if (iv1 > iv2) {
                return 1;
            } else if (iv1 < iv2) {
                return -1;
            }
        }

        return 0;
    }
}
