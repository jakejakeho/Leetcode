package src.com.leetcode.s130;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'O', 'X', 'X', 'O', 'X',},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X',},
                {'O', 'X', 'O', 'O', 'O',},
                {'X', 'X', 'O', 'X', 'O',},
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            // top left to top right
            captureUnSurrounded(board, 0, j);
            // bottom left to bottom right
            captureUnSurrounded(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            // top left to top right
            captureUnSurrounded(board, i, 0);
            // bottom left to bottom right
            captureUnSurrounded(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void captureUnSurrounded(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] == 'O') {
                board[i][j] = 'T';

                // go up
                captureUnSurrounded(board, i - 1, j);

                // go down
                captureUnSurrounded(board, i + 1, j);

                // go left
                captureUnSurrounded(board, i, j - 1);

                // go right
                captureUnSurrounded(board, i, j + 1);
            }
        }
    }
}