package com.qiao.easy;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int result = fibonacciNumber.fib(14);
        System.out.println(result);
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        System.out.println(n);
        if (n == 0 || n == 1) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);
        map.put(n, result);
        return result;
    }

}
