package com.study.unclassified;

import org.junit.Test;

import java.util.Arrays;

/**
 * 八幢房屋组成的部落，以单元表示，排成直线。每天每个单元都与它相邻单元（邻居）竞争。整数值1表示一个活跃单元，数值0表示一个非活跃单元。如果其相邻单元都活跃或者都不活跃，那么该单元第二天的状态变为不活跃；否则该单元第二天的状态为活跃。部落两端的单元都只有一个邻居单元，我们可以假设他们的另一个邻近单元一直处于不活跃的状态。即使更新状态后，要考虑其之前的状态以及更新其他单元状态。应同时更新所有单元的单元信息。
 *
 * 编写一个算法，求出给定天数后所有单元的输出状态。
 *
 * 输入：cells表示当前单元状态的证书列表，days表示天数的整数。
 *
 * 输出：返回表示给定天数后单元状态的整数列表。
 */
public class Colony {

    @Test
    public void test() {
        int[] cells = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(colony(cells, 4)));
    }

    public int[] colony(int[] cells, int days) {
        for (int i = 0; i < days; i++) {
            int beforeJ = 0;
            for (int j = 0; j < cells.length; j++) {
                int tempJ = cells[j];
                int afterJ = 0;
                if (j != cells.length - 1) {
                    afterJ = cells[j + 1];
                }

                if (beforeJ == afterJ) {
                    cells[j] = 0;
                } else {
                    cells[j] = 1;
                }
                beforeJ = tempJ;
            }
        }
        return cells;
    }

}
