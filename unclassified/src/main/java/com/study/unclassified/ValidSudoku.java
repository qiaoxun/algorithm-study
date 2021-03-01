package com.study.unclassified;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    @Test
    public void test() {
        for (int i = 0; i < 9; i++) {
            System.out.println((i/3) * 3);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rowsMap = new HashMap[9];
        Map<Integer, Integer>[] columnsMap = new HashMap[9];
        Map<Integer, Integer>[] boxMap = new HashMap[9];

        for (int i = 0; i < board.length; i++) {
            rowsMap[i] = new HashMap<>();
            columnsMap[i] = new HashMap<>();
            boxMap[i] = new HashMap<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int val = c;
                if (rowsMap[i].containsKey(val)) {
                    return false;
                } else {
                    rowsMap[i].put(val, j);
                }

                if (columnsMap[j].containsKey(val)) {
                    return false;
                } else {
                    columnsMap[j].put(val, j);
                }

                int boxIndex = (i / 3 ) * 3 + j / 3;
                if (boxMap[boxIndex].containsKey(val)) {
                    return false;
                } else {
                    boxMap[boxIndex].put(val, i);
                }
            }
        }
        return true;
    }

}
