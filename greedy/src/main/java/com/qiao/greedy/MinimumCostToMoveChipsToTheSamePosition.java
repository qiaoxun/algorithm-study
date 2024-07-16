package com.qiao.greedy;

public class MinimumCostToMoveChipsToTheSamePosition {

    public static void main(String[] args) {

    }

    public int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        int evenCount = 0;

        for (int i : position) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(oddCount, evenCount);
    }

}
