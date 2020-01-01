package com.study.unclassified;

public class CanCompleteCircuit {

    public static void main(String[] args) {
//        int[] gas = {4,5,2,6,5,3};
//        int[] gas = {1,2,3,4,5};
        int[] gas = {3, 3, 3};
//        int[] cost = {3,2,7,3,2,9};
//        int[] cost = {3,4,5,1,2};
        int[] cost = {3, 3, 4};
        System.out.println(new CanCompleteCircuit().canCompleteCircuit1(gas, cost));
    }

    /**
     * 循环的方式去求和
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int length = gas.length;
        int tempLength = 0;
        tempLength = length;
        int total = 0;
        int pos = 0;
        for (int i = 0; i < tempLength; i++) {
            System.out.println("i = " + i);
            if (tempLength > 2 * length - 1) {
                pos = -1;
                break;
            }

            int j = i;
            if (j >= length) {
                j = i - length;
            }

            total += gas[j] - cost[j];
            System.out.println("total is " + total + ", pos is " + pos);
            if (total < 0) {
                tempLength = length + i + 1;
                System.out.println("tempLength = " + tempLength);
                total = 0;
                pos = i + 1;
            }
        }
        // position should less than length
        return total >= 0 ? pos : -1;
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
