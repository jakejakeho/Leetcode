package src.com.leetcode150.ArraysHashing.Q8ValidSudoku;
class Solution {

    public boolean isValidSudoku(char[][] board) {
        // horizontal
        for (int i = 0; i < board.length; i++) {
            int[] arr = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0';
                    arr[num - 1]++;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > 1) {
                    return false;
                }
            }
        }

        // vertical
        for (int i = 0; i < board.length; i++) {
            int[] arr = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                char c = board[j][i];
                if (c != '.') {
                    int num = c - '0';
                    arr[num - 1]++;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > 1) {
                    return false;
                }
            }
        }

        // square
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] arr = new int[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i * 3 + k][j * 3 + l] != '.') {
                            int num = board[i * 3 + k][j * 3 + l] - '0';
                            if (num >= 1 && num <= 9) {
                                arr[num - 1]++;
                            }
                        }
                    }
                }
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
