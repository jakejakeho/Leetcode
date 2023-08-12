package src.com.leetcode.s36;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] exists = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (exists[board[i][j] - '1'])
                    return false;
                exists[board[i][j] - '1'] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] exists = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (exists[board[j][i] - '1'])
                    return false;
                exists[board[j][i] - '1'] = true;
            }
        }

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] exists = new boolean[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i * 3 + k][j * 3 + l] == '.')
                            continue;
                        if (exists[board[i * 3 + k][j * 3 + l] - '1'])
                            return false;
                        exists[board[i * 3 + k][j * 3 + l] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };
        Solution solution = new Solution();

        System.out.println("Input: board = " + Arrays.deepToString(board));
        System.out.println("Output: " + solution.isValidSudoku(board));
    }
}