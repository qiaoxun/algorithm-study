package com.qiao.greedy;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int mostWater = containerWithMostWater.containerWithMostWater(height);
        System.out.println(mostWater);
    }

    public int containerWithMostWater(int[] array) {
        int mostWater = 0;
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int tempMostWater = (j - i) * (Math.min(array[i], array[j]));
            mostWater = Math.max(mostWater, tempMostWater);

            if (array[i] < array[j]) {
                i++;
            } else {
                j--;
            }
        }
        return mostWater;
    }

}
