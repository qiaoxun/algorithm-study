package com.studu.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DynamicProgramming {

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Test
    public void test1() {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        Long start = System.currentTimeMillis();
        System.out.println(dynamicProgramming.fibonacciCallBack(40));
        Long end = System.currentTimeMillis();
        System.out.println("cost " + (end - start));
    }

    /**
     * call back
     * @param i
     * @return
     */
    public int fibonacciCallBack(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fibonacciCallBack(i - 1) + fibonacciCallBack(i - 2);
        }
    }


    @Test
    public void test2() {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Long start = System.currentTimeMillis();
        System.out.println(dynamicProgramming.fibonacci2(10000, map));
        Long end = System.currentTimeMillis();
        System.out.println("cost " + (end - start));
    }

    /**
     *
     * @param i
     * @param map
     * @return
     */
    public int fibonacci2(int i, Map<Integer, Integer> map) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            if (map.containsKey(i)) {
                return map.get(i);
            }

            int before2 = fibonacci2(i - 2, map);
            map.put(i - 2, before2);
            int before1 = fibonacci2(i - 1, map);
            map.put(i - 1, before1);

            return  before1 + before2;
        }
    }

    @Test
    public void test3() {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        Long start = System.currentTimeMillis();
        System.out.println(dynamicProgramming.fibonacci3(10000));
        Long end = System.currentTimeMillis();
        System.out.println("cost " + (end - start));
    }

    public int fibonacci3(int i) {

        int[] arr = new int[i];
        arr[0] = 1;
        arr[1] = 1;

        for (int j = 2; j < i; j++) {
            arr[j] = arr [j - 1] + arr[j - 2];
        }

        return arr[i - 1];
    }

}
