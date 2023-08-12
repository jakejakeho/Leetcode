package src.com.leetcode.s36;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] existsMap = new boolean[10];
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int value = board[i][j] - '0';
                if (existsMap[value]) {
                    return false;
                } else {
                    existsMap[value] = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            boolean[] existsMap = new boolean[10];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                int value = board[j][i] - '0';
                if (existsMap[value]) {
                    return false;
                } else {
                    existsMap[value] = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] existsMap = new boolean[10];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i * 3 + k][j * 3 + l] == '.') continue;
                        int value = board[i * 3 + k][j * 3 + l] - '0';
                        if (existsMap[value]) {
                            return false;
                        } else {
                            existsMap[value] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}