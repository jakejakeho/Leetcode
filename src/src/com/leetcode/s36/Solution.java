package src.com.leetcode.s36;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            int[] exists = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == '.') continue;
                ;
                int value = chars[j] - '0';
                if (exists[value] == 1) {
                    System.out.println("1");
                    return false;
                } else {
                    exists[value] = 1;
                }
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            int[] exists = new int[10];
            for (char[] chars : board) {
                if (chars[i] == '.') continue;
                int value = chars[i] - '0';
                if (exists[value] == 1) {
                    System.out.println("2");
                    return false;
                } else {
                    exists[value] = 1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] exists = new int[10];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int x = 3 * i + k;
                        int y = 3 * j + l;
                        char c = board[x][y];
                        if (c == '.') continue;
                        int value = c - '0';
                        if (exists[value] == 1) {
                            System.out.println("3");
                            return false;
                        } else {
                            exists[value] = 1;
                        }
                    }
                }
            }
        }
        return true;
    }
}