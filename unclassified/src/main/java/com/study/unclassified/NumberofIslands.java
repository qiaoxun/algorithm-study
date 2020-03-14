package com.study.unclassified;

import org.junit.Test;

public class NumberofIslands {

    @Test
    public void test() {
        char[][] grid = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };

        char[][] grid1 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };


        char[][] grid2 = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };

        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int[][] dfs = new int[grid.length][grid[0].length];
        int num = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && dfs[i][j] == 0) {
                    dfsRecurse(i, j, grid, dfs, num++);
                }
            }
        }

        for (int i = 0; i < dfs.length; i++) {
            for (int j = 0; j < dfs[i].length; j++) {
                System.out.print(dfs[i][j]);
            }
            System.out.println();
        }

        return num - 1;
    }

    private void dfsRecurse(int i, int j, char[][] grid, int[][] dfs, int num) {
        if (j >= 0 && i >= 0 && i < grid.length && j < grid[i].length) {
            if (grid[i][j] == '1' && dfs[i][j] == 0) {
                dfs[i][j] = num;
                dfsRecurse(i - 1, j, grid, dfs, num);
                dfsRecurse(i + 1, j, grid, dfs, num);
                dfsRecurse(i, j - 1, grid, dfs, num);
                dfsRecurse(i, j + 1, grid, dfs, num);
            }
        }
    }

}
