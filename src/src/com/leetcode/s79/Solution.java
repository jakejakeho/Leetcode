package src.com.leetcode.s79;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (recursive(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean recursive(char[][] board, String word, int currentI, int currentJ, int matchIndex,
                              boolean[][] visited) {
        char currentChar = word.charAt(matchIndex);
        boolean charMatch = board[currentI][currentJ] == currentChar;
        if (charMatch && matchIndex == word.length() - 1) {
            return true;
        }
        if (charMatch) {
            visited[currentI][currentJ] = true;
            boolean exist = false;
            // go up
            if (currentI - 1 >= 0 && !visited[currentI - 1][currentJ])
                if (recursive(board, word, currentI - 1, currentJ, matchIndex + 1, visited))
                    exist = true;
                else
                    visited[currentI - 1][currentJ] = false;

            // go down
            if (currentI + 1 < board.length && !visited[currentI + 1][currentJ])
                if (recursive(board, word, currentI + 1, currentJ, matchIndex + 1, visited))
                    exist = true;
                else
                    visited[currentI + 1][currentJ] = false;

            // go left
            if (currentJ - 1 >= 0 && !visited[currentI][currentJ - 1])
                if (recursive(board, word, currentI, currentJ - 1, matchIndex + 1, visited))
                    exist = true;
                else
                    visited[currentI][currentJ - 1] = false;

            // go right
            if (currentJ + 1 < board[0].length && !visited[currentI][currentJ + 1])
                if (recursive(board, word, currentI, currentJ + 1, matchIndex + 1, visited))
                    exist = true;
                else
                    visited[currentI][currentJ + 1] = false;
            return exist;
        }
        return false;
    }
}