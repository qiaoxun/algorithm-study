package com.study.unclassified;

public class CanCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        for (int i = 0; i < length; i++) {
            int result = calc(gas, cost, i, length);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    private int calc(int[] gas, int[] cost, int i, int length) {
        int allGas = 0;
        int allCost = 0;
        for (int j = i; j < length; j++) {
            allGas += gas[j];
            allCost += cost[j];
            if (allCost > allGas) return -1;
        }
        for (int j = 0; j < i; j++) {
            allGas += gas[j];
            allCost += cost[j];
            if (allCost > allGas) return -1;
        }
        return i;
    }

}
