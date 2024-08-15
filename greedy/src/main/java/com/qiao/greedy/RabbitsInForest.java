package com.qiao.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RabbitsInForest {

    public static void main(String[] args) {
        int[] answers1 = {1, 1, 2};

        int[] answers2 = {10, 10, 10};
    }

    public int numRabbits(int[] answers) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            int current = answers[i];
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        AtomicInteger totalNum = new AtomicInteger();

        map.entrySet().forEach(entry -> {
            int key = entry.getKey();
            int value = entry.getValue();

            int key1 = key + 1;

            int mod = value / key1;
            int rest = value % key1;

            if (rest > 0) {
                mod += 1;
            }
            totalNum.addAndGet(mod * key1);
        });

        return totalNum.get();
    }

}
