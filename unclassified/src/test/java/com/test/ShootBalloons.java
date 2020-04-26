package com.test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ShootBalloons {

    @Test
    public void test() {
        int colors = 4;
        int[] shoots = {2,5,3,1,3,2,4,1,0,5,4,3};
        System.out.println(shoot(colors, shoots));
    }

    public int shoot(int colors, int[] shoots) {
        int length = shoots.length;
        int mini = length;
        for (int i = 0; i < length - colors; i++) {
            if (shoots[i] == 0) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            set.add(shoots[i]);
            int right = i + 1;
            while (right < length) {
                if (shoots[right] == 0) {
                    right++;
                    continue;
                }
                set.add(shoots[right]);
                if (set.size() < colors) {
                    right++;
                } else {
                    break;
                }
            }

            if (set.size() == colors) {
                mini = Math.min(right - i + 1, mini);
            }
        }
        return mini;
    }

}
