package src.com.leetcode.s36;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Map<Character, Integer> rowMap = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    rowMap.put(board[i][j], rowMap.getOrDefault(board[i][j], 0) + 1);
                }
            }
            for (Map.Entry<Character, Integer> entry: rowMap.entrySet()) {
                if (entry.getValue() > 1) {
                    return false;
                }
            }
        }

        for (int j = 0; j < board.length; j++) {
            Map<Character, Integer> columnMap = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    columnMap.put(board[i][j], columnMap.getOrDefault(board[i][j], 0) + 1);
                }
            }
            for (Map.Entry<Character, Integer> entry: columnMap.entrySet()) {
                if (entry.getValue() > 1) {
                    return false;
                }
            }
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Map<Character, Integer> blockMap = new HashMap<>();
                for (int i = x * 3; i < (x + 1) * 3; i++) {
                    for (int j = y * 3; j < (y + 1) * 3; j++) {
                        if (board[i][j] != '.') {
                            blockMap.put(board[i][j], blockMap.getOrDefault(board[i][j], 0) + 1);
                        }
                    }
                }
                for (Map.Entry<Character, Integer> entry: blockMap.entrySet()) {
                    if (entry.getValue() > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}