package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeNumsTimes {

    @Test
    public void test() {
        System.out.println(count());
    }

    /**
     * a*b*c = 2310;
     * @return
     */
    public int count() {
        int total = 2310;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            if (total % i == 0) {
                list.add(i);
            }
        }
        int count = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            int a = list.get(i);
            for (int j = i; j < list.size() - 1; j++) {
                int b = list.get(j);
                for (int k = j; k < list.size(); k++) {
                    int c = list.get(k);
                    int threeNumTimes = a * b * c;
                    if (threeNumTimes == 2310) {
                        count++;
                    } else if (threeNumTimes > 2310) {
                        break;
                    }
                }
            }
        }
        return count;
    }

}
