package src.com.leetcode.s79;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int wordIndex, boolean[][] visited) {
        if (wordIndex < word.length() && board[i][j] != word.charAt(wordIndex)) {
            return false;
        }

        visited[i][j] = true;
        if (wordIndex + 1 == word.length()) {
            return true;
        }

        // go up
        if ((i - 1) >= 0 && !visited[i - 1][j]) {
            if (dfs(board, word, i - 1, j, wordIndex + 1, visited)) {
                return true;
            } else {
                visited[i - 1][j] = false;
            }
        }

        // go down
        if ((i + 1) < board.length && !visited[i + 1][j]) {
            if (dfs(board, word, i + 1, j, wordIndex + 1, visited)) {
                return true;
            } else {
                visited[i + 1][j] = false;
            }
        }

        // go left
        if ((j - 1) >= 0 && !visited[i][j - 1]) {
            if (dfs(board, word, i, j - 1, wordIndex + 1, visited)) {
                return true;
            } else {
                visited[i][j - 1] = false;
            }
        }

        // go right
        if ((j + 1) < board[0].length && !visited[i][j + 1]) {
            if (dfs(board, word, i, j + 1, wordIndex + 1, visited)) {
                return true;
            } else {
                visited[i][j + 1] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "ABCESEEEFS"));
    }
}